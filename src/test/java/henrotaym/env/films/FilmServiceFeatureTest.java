package henrotaym.env.films;

import static org.assertj.core.api.Assertions.*;

import henrotaym.env.ApplicationTest;
import henrotaym.env.characters.repositories.CharacterRepository;
import henrotaym.env.database.factories.CharacterFactory;
import henrotaym.env.films.entities.Film;
import henrotaym.env.films.repositories.FilmRepository;
import henrotaym.env.films.services.FilmService;
import jakarta.annotation.Resource;
import java.util.List;
import net.datafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class FilmServiceFeatureTest extends ApplicationTest {

  @Autowired FilmService filmService;
  @Autowired CharacterRepository characterRepository;
  @Autowired FilmRepository filmRepository;
  @Autowired Faker faker;

  @Resource(name = "characterFactory")
  CharacterFactory characterFactory;

  @Test
  void should_increment_film_count_when_character_exists() {
    var character =
        characterFactory.createFromBuilder(
            builder ->
                builder
                    .apiCharacterId(1L)
                    .name(faker.name().fullName())
                    .gender(faker.demographic().sex())
                    .birthYear(faker.number().numberBetween(10, 99) + "BBY")
                    .filmCount(0));

    filmService.syncPage(1);

    var updated = characterRepository.findByApiCharacterId(1L).orElseThrow();
    assertThat(updated.getFilmCount()).isGreaterThan(0);
  }

  @Test
  void should_not_fail_when_character_does_not_exist() {
    characterRepository.findByApiCharacterId(1L).ifPresent(characterRepository::delete);
    assertThat(characterRepository.findByApiCharacterId(1L)).isEmpty();

    filmService.syncPage(1);

    assertThat(characterRepository.findByApiCharacterId(1L)).isEmpty();
  }

  @Test
  void should_sync_all_films_from_api_page() {
    filmService.syncPage(1);

    List<Film> films = filmRepository.findAll();
    assertThat(films)
        .isNotEmpty()
        .allSatisfy(
            film -> {
              assertThat(film.getApiFilmId()).isNotNull();
              assertThat(film.getTitle()).isNotBlank();
              assertThat(film.getEpisodeId()).isNotNull();
            });
  }
}
