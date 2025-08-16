package henrotaym.env.swapi.factories;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

@RequiredArgsConstructor
public abstract class SwapiClientFactory {
  protected final RestClient swapiRestClient;

  protected <T> T getPage(String path, int page, Class<T> responseType) {
    return swapiRestClient
        .get()
        .uri(uri -> uri.path(path).queryParam("page", page).build())
        .accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .body(responseType);
  }
}
