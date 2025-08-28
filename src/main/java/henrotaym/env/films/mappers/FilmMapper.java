package henrotaym.env.films.mappers;

import henrotaym.env.characters.mappers.CharacterMapper;
import henrotaym.env.films.entities.Film;
import henrotaym.env.films.http.resources.FilmResource;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FilmMapper {

  private final CharacterMapper characterMapper;

  public FilmResource toResource(Film film) {
    return new FilmResource(
        film.getId(),
        film.getApiFilmId(),
        film.getTitle(),
        film.getEpisodeId(),
        film.getCharacters().stream().map(characterMapper::toResource).collect(Collectors.toSet()));
  }
}
