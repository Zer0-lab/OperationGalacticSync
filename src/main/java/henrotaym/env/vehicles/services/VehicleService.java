package henrotaym.env.vehicles.services;

import henrotaym.env.swapi.clients.VehiclesClient;
import henrotaym.env.vehicles.entities.Vehicle;
import henrotaym.env.vehicles.mappers.VehicleMapper;
import henrotaym.env.vehicles.repositories.VehicleRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehicleService {

  private final VehiclesClient vehiclesClient;
  private final VehicleRepository vehicleRepository;
  private final VehicleMapper vehicleMapper;

  @Transactional
  public void syncPage(int page) {
    var response = vehiclesClient.getVehiclePage(page);

    response
        .getResults()
        .forEach(
            resource -> {
              var fields = resource.getFields();
              Long apiId = extractIdFromUrl(fields.getUrl());

              Optional<Vehicle> existingOpt = vehicleRepository.findByApiVehicleId(apiId);

              if (existingOpt.isPresent()) {
                Vehicle existing = existingOpt.get();
                existing.setName(fields.getName());
                existing.setModel(fields.getModel());
                existing.setManufacturer(fields.getManufacturer());
                existing.setCostInCredits(fields.getCostInCredits());
                existing.setLength(fields.getLength());
                existing.setMaxAtmospheringSpeed(fields.getMaxAtmospheringSpeed());
                existing.setCrew(fields.getCrew());
                existing.setPassengers(fields.getPassengers());
                existing.setCargoCapacity(fields.getCargoCapacity());
                existing.setConsumables(fields.getConsumables());
                existing.setVehicleClass(fields.getVehicleClass());

                vehicleRepository.save(existing);
              } else {
                Vehicle newvehicle = vehicleMapper.toEntity(fields, apiId);
                vehicleRepository.save(newvehicle);
              }
            });
  }

  private Long extractIdFromUrl(String url) {
    String[] parts = url.split("/");
    return Long.parseLong(parts[parts.length - 1]);
  }
}
