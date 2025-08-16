package henrotaym.env.vehicles.repositories;

import henrotaym.env.vehicles.entities.Vehicle;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
  Optional<Vehicle> findByApiVehicleId(Long apiVehicleId);
}
