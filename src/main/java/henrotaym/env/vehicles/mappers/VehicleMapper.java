package henrotaym.env.vehicles.mappers;

import henrotaym.env.characters.mappers.CharacterMapper;
import henrotaym.env.vehicles.entities.Vehicle;
import henrotaym.env.vehicles.http.resources.VehicleResource;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VehicleMapper {

  private final CharacterMapper characterMapper;

  public VehicleResource toResource(Vehicle vehicle) {
    return new VehicleResource(
        vehicle.getId(),
        vehicle.getApiVehicleId(),
        vehicle.getName(),
        vehicle.getModel(),
        vehicle.getManufacturer(),
        vehicle.getCostInCredits(),
        vehicle.getLength(),
        vehicle.getMaxAtmospheringSpeed(),
        vehicle.getCrew(),
        vehicle.getPassengers(),
        vehicle.getCargoCapacity(),
        vehicle.getConsumables(),
        vehicle.getVehicleClass(),
        vehicle.getCharacters().stream()
            .map(characterMapper::toResource)
            .collect(Collectors.toSet()));
  }
}
