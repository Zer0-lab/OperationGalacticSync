package henrotaym.env.shared.scheduler;

import henrotaym.env.shared.enums.ProfileName;
import henrotaym.env.shared.queues.emitters.CharacterSyncEmitter;
import henrotaym.env.swapi.clients.CharactersClient;
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
public class CharacterSyncScheduler {

  private final CharactersClient charactersClient;
  private final CharacterSyncEmitter emitter;

  @Scheduled(fixedRate = 7, timeUnit = TimeUnit.DAYS)
  public void scheduleCharacterSync() {
    log.info("📤 Emission des événements SyncCharacters...");

    var firstPage = charactersClient.getPeoplePage(1);
    int totalPages = firstPage.getPages();

    for (int page = 1; page <= totalPages; page++) {
      emitter.emit(page);
    }

    log.info("✅ Événements SyncCharacters envoyés avec succès.");
  }
}
