package henrotaym.env.shared.queues.listeners;

import henrotaym.env.films.services.FilmService;
import henrotaym.env.shared.annotations.KafkaRetryableListener;
import henrotaym.env.shared.enums.ProfileName;
import henrotaym.env.shared.queues.events.FilmsSyncEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(ProfileName.QUEUE)
@RequiredArgsConstructor
public class FilmsSyncListener implements Listener<FilmsSyncEvent> {

  private final FilmService filmService;

  @Override
  @KafkaRetryableListener(FilmsSyncEvent.EVENT_NAME)
  public void listen(FilmsSyncEvent event) {
    filmService.syncPage(event.getPage());
  }
}
