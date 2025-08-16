package henrotaym.env.shared.mappers;

import henrotaym.env.characters.entities.Character;
import henrotaym.env.characters.http.resources.CharacterResource;
import henrotaym.env.characters.mappers.CharacterMapper;
import henrotaym.env.films.entities.Film;
import henrotaym.env.films.http.resources.FilmResource;
import henrotaym.env.films.mappers.FilmMapper;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Getter
public class ResourceMapper {

  private final CharacterMapper characterMapper;
  private final FilmMapper filmMapper;

  public CharacterResource characterResource(Character character) {
    return characterMapper.toResource(character);
  }

  public FilmResource filmResource(Film film) {
    return filmMapper.toResource(film);
  }
}
