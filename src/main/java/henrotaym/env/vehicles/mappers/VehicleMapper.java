package henrotaym.env.vehicles.mappers;

import henrotaym.env.swapi.http.resources.vehicles.VehicleFields;
import henrotaym.env.vehicles.entities.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class VehicleMapper {

  public Vehicle toEntity(VehicleFields fields, Long apiId) {
    return Vehicle.builder()
        .apiVehicleId(apiId)
        .name(fields.getName())
        .model(fields.getModel())
        .manufacturer(fields.getManufacturer())
        .costInCredits(fields.getCostInCredits())
        .length(fields.getLength())
        .maxAtmospheringSpeed(fields.getMaxAtmospheringSpeed())
        .crew(fields.getCrew())
        .passengers(fields.getPassengers())
        .cargoCapacity(fields.getCargoCapacity())
        .consumables(fields.getConsumables())
        .vehicleClass(fields.getVehicleClass())
        .build();
  }
}
