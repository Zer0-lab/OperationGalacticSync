package henrotaym.env.shared.scheduler;

import henrotaym.env.shared.enums.ProfileName;
import henrotaym.env.shared.queues.emitters.FilmSyncEmitter;
import henrotaym.env.swapi.clients.FilmsClient;
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
public class FilmSyncScheduler {

  private final FilmsClient filmsClient;
  private final FilmSyncEmitter emitter;

  @Scheduled(fixedRate = 7, timeUnit = TimeUnit.DAYS)
  public void scheduleFilmSync() {
    log.info("📤 Emission des événements SyncFilms...");

    var firstPage = filmsClient.getFilmsPage(1);
    int totalPages = firstPage.getPages();

    for (int page = 1; page <= totalPages; page++) {
      emitter.emit(page);
    }

    log.info("✅ Événements SyncFilms envoyés avec succès.");
  }
}
