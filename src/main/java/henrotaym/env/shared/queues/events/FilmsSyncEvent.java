package henrotaym.env.shared.queues.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FilmsSyncEvent implements Event {
  public static final String EVENT_NAME = "sync.films";

  private int page;

  @Override
  public String eventName() {
    return EVENT_NAME;
  }
}
