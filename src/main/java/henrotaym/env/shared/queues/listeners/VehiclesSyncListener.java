package henrotaym.env.shared.queues.listeners;

import henrotaym.env.shared.annotations.KafkaRetryableListener;
import henrotaym.env.shared.enums.ProfileName;
import henrotaym.env.shared.queues.events.VehiclesSyncEvent;
import henrotaym.env.vehicles.services.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(ProfileName.QUEUE)
@RequiredArgsConstructor
public class VehiclesSyncListener implements Listener<VehiclesSyncEvent> {

  private final VehicleService vehicleService;

  @Override
  @KafkaRetryableListener(VehiclesSyncEvent.EVENT_NAME)
  public void listen(VehiclesSyncEvent event) {
    vehicleService.syncPage(event.getPage());
  }
}
