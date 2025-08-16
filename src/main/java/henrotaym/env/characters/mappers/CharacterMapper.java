package henrotaym.env.characters.mappers;

import henrotaym.env.characters.entities.Character;
import henrotaym.env.characters.http.resources.CharacterResource;
import org.springframework.stereotype.Component;

@Component
public class CharacterMapper {

  public CharacterResource toResource(Character character) {
    return new CharacterResource(
        character.getId(),
        character.getApiCharacterId(),
        character.getName(),
        character.getGender(),
        character.getBirthYear(),
        character.getFilmCount(),
        null
        );
  }
}
