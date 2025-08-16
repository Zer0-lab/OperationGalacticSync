package henrotaym.env.shared.queues.emitters;

import henrotaym.env.shared.queues.events.VehiclesSyncEvent;
import org.springframework.stereotype.Component;

@Component
public class VehicleSyncEmitter {
  private final Emitter emitter;

  public VehicleSyncEmitter(Emitter emitter) {
    this.emitter = emitter;
  }

  public void emit(int page) {
    emitter.send(new VehiclesSyncEvent(page));
  }
}
