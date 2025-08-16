package henrotaym.env.shared.scheduler;

import henrotaym.env.shared.enums.ProfileName;
import henrotaym.env.shared.queues.emitters.VehicleSyncEmitter;
import henrotaym.env.swapi.clients.VehiclesClient;
import java.util.concurrent.TimeUnit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
@Profile(ProfileName.SCHEDULER)
public class VehicleSyncScheduler {

  private final VehiclesClient vehiclesClient;
  private final VehicleSyncEmitter emitter;

  @Scheduled(fixedRate = 7, timeUnit = TimeUnit.DAYS)
  public void schedulevehicleSync() {
    log.info("📤 Emission des événements SyncVehicles...");

    var firstPage = vehiclesClient.getVehiclePage(1);
    int totalPages = firstPage.getPages();

    for (int page = 1; page <= totalPages; page++) {
      emitter.emit(page);
    }

    log.info("✅ Événements Syncvehicles envoyés avec succès.");
  }
}
