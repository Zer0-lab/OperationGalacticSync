package henrotaym.env.shared.queues.emitters;

import henrotaym.env.shared.queues.events.CharactersSyncEvent;
import org.springframework.stereotype.Component;

@Component
public class CharacterSyncEmitter {
  private final Emitter emitter;

  public CharacterSyncEmitter(Emitter emitter) {
    this.emitter = emitter;
  }

  public void emit(int page) {
    emitter.send(new CharactersSyncEvent(page));
  }
}
