package henrotaym.env.films.mappers;

import henrotaym.env.films.entities.Film;
import henrotaym.env.films.http.resources.FilmResource;
import org.springframework.stereotype.Component;

@Component
public class FilmMapper {

  public FilmResource toResource(Film film) {
    return new FilmResource(
        film.getId(),
        film.getApiFilmId(),
        film.getTitle(),
        film.getEpisodeId(),
        null // characters non inclus (bonus futur)
        );
  }
}
