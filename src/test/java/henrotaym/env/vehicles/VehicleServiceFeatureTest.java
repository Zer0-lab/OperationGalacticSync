package henrotaym.env.vehicles;

import static org.assertj.core.api.Assertions.*;

import henrotaym.env.ApplicationTest;
import henrotaym.env.vehicles.entities.Vehicle;
import henrotaym.env.vehicles.repositories.VehicleRepository;
import henrotaym.env.vehicles.services.VehicleService;
import java.util.List;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class VehicleServiceFeatureTest extends ApplicationTest {

  @Autowired VehicleService vehicleService;
  @Autowired VehicleRepository vehicleRepository;
  @Autowired Faker faker;

  @Test
  void should_create_new_vehicle() {
    assertThat(vehicleRepository.findByApiVehicleId(4L)).isEmpty();

    vehicleService.syncPage(1);

    var vehicle = vehicleRepository.findByApiVehicleId(4L);
    assertThat(vehicle).isPresent();
  }

  @Test
  void should_update_existing_vehicle() {
    String oldName = faker.vehicle().model();
    String oldModel = faker.space().galaxy();
    String oldManufacturer = faker.company().name();

    vehicleRepository.save(
        Vehicle.builder()
            .apiVehicleId(4L)
            .name(oldName)
            .model(oldModel)
            .manufacturer(oldManufacturer)
            .build());

    vehicleService.syncPage(1);

    Vehicle updated = vehicleRepository.findByApiVehicleId(4L).orElseThrow();

    assertThat(updated.getName()).isNotEqualTo(oldName);
    assertThat(updated.getModel()).isNotEqualTo(oldModel);
    assertThat(updated.getManufacturer()).isNotEqualTo(oldManufacturer);
  }

  @Test
  void should_sync_all_vehicles_from_api_page() {
    vehicleService.syncPage(1);

    List<Vehicle> vehicles = vehicleRepository.findAll();
    assertThat(vehicles)
        .isNotEmpty()
        .allSatisfy(
            vehicle -> {
              assertThat(vehicle.getApiVehicleId()).isNotNull();
              assertThat(vehicle.getName()).isNotBlank();
              assertThat(vehicle.getModel()).isNotBlank();
              assertThat(vehicle.getManufacturer()).isNotBlank();
            });
  }
}
