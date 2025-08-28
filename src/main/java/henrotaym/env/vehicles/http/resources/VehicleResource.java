package henrotaym.env.vehicles.http.resources;

import henrotaym.env.characters.http.resources.CharacterResource;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class VehicleResource {
  private Long id;
  private Long apiVehicleId;
  private String name;
  private String model;
  private String manufacturer;
  private String costInCredits;
  private String length;
  private String maxAtmospheringSpeed;
  private String crew;
  private String passengers;
  private String cargoCapacity;
  private String consumables;
  private String vehicleClass;
  private Set<CharacterResource> characters;
}
