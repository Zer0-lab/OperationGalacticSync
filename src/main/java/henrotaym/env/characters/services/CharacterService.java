package henrotaym.env.characters.services;

import com.querydsl.core.types.dsl.BooleanExpression;
import henrotaym.env.characters.entities.Character;
import henrotaym.env.characters.entities.QCharacter;
import henrotaym.env.characters.repositories.CharacterRepository;
import henrotaym.env.swapi.clients.CharactersClient;
import henrotaym.env.swapi.http.resources.characters.CharacterFields;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CharacterService {

  private final CharactersClient charactersClient;
  private final CharacterRepository characterRepository;

  @Transactional
  public void syncPage(int page) {
    var response = charactersClient.getPeoplePage(page);

    response
        .getResults()
        .forEach(
            resource -> {
              CharacterFields fields = resource.getFields();
              Long apiId = extractIdFromUrl(fields.getUrl());

              QCharacter qCharacter = QCharacter.character;
              BooleanExpression predicate = qCharacter.apiCharacterId.eq(apiId);

              characterRepository
                  .findOne(predicate)
                  .ifPresentOrElse(
                      existing -> {
                        updateCharacter(existing, fields);
                        characterRepository.save(existing);
                      },
                      () -> {
                        Character newCharacter = Character.builder()
                            .apiCharacterId(apiId)
                            .name(fields.getName())
                            .gender(fields.getGender())
                            .birthYear(fields.getBirthYear())
                            .build();
                        characterRepository.save(newCharacter);
                      });
            });
  }

  private Long extractIdFromUrl(String url) {
    String[] parts = url.split("/");
    return Long.parseLong(parts[parts.length - 1]);
  }

  private void updateCharacter(Character character, CharacterFields fields) {
    character.setName(fields.getName());
    character.setGender(fields.getGender());
    character.setBirthYear(fields.getBirthYear());
  }
}