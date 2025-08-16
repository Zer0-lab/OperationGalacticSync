package henrotaym.env.shared.queues.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VehiclesSyncEvent implements Event {
  public static final String EVENT_NAME = "sync.vehicles";

  private int page;

  @Override
  public String eventName() {
    return EVENT_NAME;
  }
}
