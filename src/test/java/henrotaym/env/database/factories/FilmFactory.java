package henrotaym.env.database.factories;

import henrotaym.env.films.entities.Film;
import henrotaym.env.films.repositories.FilmRepository;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;
import lombok.Getter;
import net.datafaker.Faker;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("filmFactory")
@Profile("test")
@Getter
public class FilmFactory extends EntityFactory<Film> {

  private final FilmRepository filmRepository;
  private final AtomicLong idGenerator = new AtomicLong(100);

  public FilmFactory(Faker faker, FilmRepository filmRepository) {
    super(faker, filmRepository);
    this.filmRepository = filmRepository;
  }

  @Override
  protected Film entity() {
    return new Film();
  }

  @Override
  protected void attributes(Film film) {
    film.setApiFilmId(idGenerator.getAndIncrement());
    film.setTitle(faker.book().title());
    film.setEpisodeId(faker.number().numberBetween(1, 9));
  }

  public Film createFromBuilder(Consumer<Film.FilmBuilder> callback) {
    var builder = Film.builder();
    callback.accept(builder);
    return filmRepository.save(builder.build());
  }

  public Film createWithApiId(long apiFilmId) {
    return createFromBuilder(b -> b.apiFilmId(apiFilmId));
  }
}
