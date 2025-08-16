package henrotaym.env.swapi.clients;

import henrotaym.env.swapi.factories.SwapiClientFactory;
import henrotaym.env.swapi.http.resources.peoples.PeoplePageResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class PeoplesClient extends SwapiClientFactory {

  public PeoplesClient(RestClient swapiRestClient) {
    super(swapiRestClient);
  }

  public PeoplePageResponse getPeoplePage(int page) {
    return getPage("/people", page, PeoplePageResponse.class);
  }
}
