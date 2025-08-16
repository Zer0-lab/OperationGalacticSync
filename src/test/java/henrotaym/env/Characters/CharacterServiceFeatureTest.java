package henrotaym.env.Characters;

import static org.assertj.core.api.Assertions.*;

import henrotaym.env.ApplicationTest;
import henrotaym.env.characters.entities.Character;
import henrotaym.env.characters.repositories.CharacterRepository;
import henrotaym.env.characters.services.CharacterService;
import henrotaym.env.database.factories.CharacterFactory;
import jakarta.annotation.Resource;
import java.util.List;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class CharacterServiceFeatureTest extends ApplicationTest {

  @Autowired CharacterService characterService;
  @Autowired CharacterRepository characterRepository;
  @Autowired Faker faker;

  @Resource(name = "characterFactory")
  CharacterFactory characterFactory;

  @Test
  void should_update_existing_character() {
    var existing =
        characterFactory.createFromBuilder(
            builder ->
                builder
                    .apiCharacterId(1L)
                    .name(faker.name().firstName())
                    .gender(faker.demographic().sex())
                    .birthYear(faker.number().numberBetween(100, 9999) + "BBY")
                    .filmCount(0));

    characterService.syncPage(1);

    var updated = characterRepository.findByApiCharacterId(1L).orElseThrow();

    assertThat(updated.getName()).isEqualTo("Luke Skywalker");
    assertThat(updated.getGender()).isEqualTo("male");
    assertThat(updated.getBirthYear()).isEqualTo("19BBY");
  }

  @Test
  void should_create_new_character() {
    assertThat(characterRepository.findByApiCharacterId(5L)).isEmpty();

    characterService.syncPage(1);

    var character = characterRepository.findByApiCharacterId(5L);
    assertThat(character).isPresent();
  }

  @Test
  void should_sync_all_characters_from_api_page() {
    characterService.syncPage(1);

    List<Character> characters = characterRepository.findAll();
    assertThat(characters)
        .isNotEmpty()
        .allSatisfy(
            character -> {
              assertThat(character.getApiCharacterId()).isNotNull();
              assertThat(character.getName()).isNotBlank();
              assertThat(character.getGender()).isNotBlank();
              assertThat(character.getBirthYear()).isNotBlank();
            });
  }
}
