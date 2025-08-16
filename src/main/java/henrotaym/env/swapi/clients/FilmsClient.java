package henrotaym.env.swapi.clients;

import henrotaym.env.swapi.factories.SwapiClientFactory;
import henrotaym.env.swapi.http.resources.films.FilmPageResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class FilmsClient extends SwapiClientFactory {

  public FilmsClient(RestClient swapiRestClient) {
    super(swapiRestClient);
  }

  public FilmPageResponse getFilmsPage(int page) {
    return getPage("/films", page, FilmPageResponse.class);
  }
}
