package henrotaym.env.swapi.clients;

import henrotaym.env.swapi.factories.SwapiClientFactory;
import henrotaym.env.swapi.http.resources.vehicles.VehiclesPageResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class VehiclesClient extends SwapiClientFactory {

  public VehiclesClient(RestClient swapiRestClient) {
    super(swapiRestClient);
  }

  public VehiclesPageResponse getVehiclePage(int page) {
    return getPage("/vehicles", page, VehiclesPageResponse.class);
  }
}
