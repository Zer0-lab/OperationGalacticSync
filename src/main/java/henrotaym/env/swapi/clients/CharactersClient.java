package henrotaym.env.swapi.clients;

import henrotaym.env.swapi.factories.SwapiClientFactory;
import henrotaym.env.swapi.http.resources.characters.CharactersPageResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class CharactersClient extends SwapiClientFactory {

  public CharactersClient(RestClient swapiRestClient) {
    super(swapiRestClient);
  }

  public CharactersPageResponse getPeoplePage(int page) {
    return getPage("/people", page, CharactersPageResponse.class);
  }
}
