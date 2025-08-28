package henrotaym.env.films.http.resources;

import java.util.Set;

import henrotaym.env.characters.http.resources.CharacterResource;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FilmResource {
  private Long id;
  private Long apiFilmId;
  private String title;
  private Integer episodeId;
  private Set<CharacterResource> characters;
}
