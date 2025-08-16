package henrotaym.env.films.services;

import henrotaym.env.films.entities.Film;
import henrotaym.env.films.repositories.FilmRepository;
import henrotaym.env.swapi.clients.FilmsClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FilmService {

  private final FilmsClient filmsClient;
  private final FilmRepository filmRepository;

  public void syncPage(int page) {
    var response = filmsClient.getFilmsPage(page);
    response
        .getResults()
        .forEach(
            resource -> {
              var fields = resource.getFields();
              Long apiId = extractIdFromUrl(fields.getUrl());

              filmRepository
                  .findByApiFilmId(apiId)
                  .ifPresentOrElse(
                      existing -> {
                        existing.setTitle(fields.getTitle());
                        existing.setEpisodeId(fields.getEpisodeId());
                        filmRepository.save(existing);
                      },
                      () -> {
                        var newFilm = new Film();
                        newFilm.setApiFilmId(apiId);
                        newFilm.setTitle(fields.getTitle());
                        newFilm.setEpisodeId(fields.getEpisodeId());
                        filmRepository.save(newFilm);
                      });
            });
  }

  private Long extractIdFromUrl(String url) {
    var parts = url.split("/");
    return Long.parseLong(parts[parts.length - 1]);
  }
}
