package henrotaym.env.films.http.resources;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FilmResource {
  private Long id;
  private Long apiFilmId;
  private String title;
  private Integer episodeId;
  private Set<SimpleCharacterResource> characters; // Résumé des personnages
}
