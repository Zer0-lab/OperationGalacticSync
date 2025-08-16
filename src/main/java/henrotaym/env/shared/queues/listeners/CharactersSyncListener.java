package henrotaym.env.shared.queues.listeners;

import henrotaym.env.characters.services.CharacterService;
import henrotaym.env.shared.annotations.KafkaRetryableListener;
import henrotaym.env.shared.enums.ProfileName;
import henrotaym.env.shared.queues.events.CharactersSyncEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(ProfileName.QUEUE)
@RequiredArgsConstructor
public class CharactersSyncListener implements Listener<CharactersSyncEvent> {

  private final CharacterService characterService;

  @Override
  @KafkaRetryableListener(CharactersSyncEvent.EVENT_NAME)
  public void listen(CharactersSyncEvent event) {
    characterService.syncPage(event.getPage());
  }
}
