package henrotaym.env.shared.queues.emitters;

import henrotaym.env.shared.queues.events.FilmsSyncEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FilmSyncEmitter {

  private final Emitter emitter;

  public void emit(int page) {
    emitter.send(new FilmsSyncEvent(page));
  }
}
