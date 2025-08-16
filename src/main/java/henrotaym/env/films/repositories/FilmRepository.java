package henrotaym.env.films.repositories;

import henrotaym.env.films.entities.Film;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
  Optional<Film> findByApiFilmId(Long apiFilmId);
}
