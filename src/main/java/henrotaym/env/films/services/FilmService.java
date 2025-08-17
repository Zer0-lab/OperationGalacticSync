package henrotaym.env.films.services;

import henrotaym.env.characters.entities.Character;
import henrotaym.env.characters.repositories.CharacterRepository;
import henrotaym.env.films.entities.Film;
import henrotaym.env.films.repositories.FilmRepository;
import henrotaym.env.swapi.clients.FilmsClient;
import jakarta.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FilmService {

  private final FilmsClient filmsClient;
  private final FilmRepository filmRepository;
  private final CharacterRepository characterRepository;

  @Transactional
  public void syncPage(int page) {
    var response = filmsClient.getFilmsPage(page);

    response
        .getResults()
        .forEach(
            resource -> {
              var fields = resource.getFields();
              Long apiId = extractIdFromUrl(fields.getUrl());

              if (filmRepository.findByApiFilmId(apiId).isPresent()) {
                return;
              }

              Set<Character> relatedCharacters = new HashSet<>();
              fields
                  .getCharacters()
                  .forEach(
                      characterUrl -> {
                        Long charId = extractIdFromUrl(characterUrl);

                        characterRepository
                            .findByApiCharacterId(charId)
                            .ifPresent(
                                character -> {
                                  relatedCharacters.add(character);
                                  character.setFilmCount(character.getFilmCount() + 1);
                                  characterRepository.save(character);
                                });
                      });

              var film = new Film();
              film.setApiFilmId(apiId);
              film.setTitle(fields.getTitle());
              film.setEpisodeId(fields.getEpisodeId());
              film.setCharacters(relatedCharacters);

              filmRepository.save(film);
            });
  }

  private Long extractIdFromUrl(String url) {
    String[] parts = url.split("/");
    return Long.parseLong(parts[parts.length - 1]);
  }
}
