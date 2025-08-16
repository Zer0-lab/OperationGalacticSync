package henrotaym.env.swapi.http.resources.vehicles;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;

@Getter
public class VehicleFields {

  private String name;
  private String model;
  private String manufacturer;

  @JsonProperty("cost_in_credits")
  private String costInCredits;

  private String length;

  @JsonProperty("max_atmosphering_speed")
  private String maxAtmospheringSpeed;

  private String crew;
  private String passengers;

  @JsonProperty("cargo_capacity")
  private String cargoCapacity;

  private String consumables;

  @JsonProperty("vehicle_class")
  private String vehicleClass;

  private List<String> pilots;
  private List<String> films;

  private String url;
}
