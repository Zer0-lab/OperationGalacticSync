package henrotaym.env.films.mappers;

import henrotaym.env.films.entities.Film;
import henrotaym.env.films.http.resources.FilmResource;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class FilmMapper {

  public FilmResource toResource(Film film) {
    return new FilmResource(
        film.getId(),
        film.getApiFilmId(),
        film.getTitle(),
        film.getEpisodeId(),
        film.getCharacters().stream()
            .map(
                character ->
                    new SimpleCharacterResource(
                        character.getId(), character.getApiCharacterId(), character.getName()))
            .collect(Collectors.toSet()));
  }
}
