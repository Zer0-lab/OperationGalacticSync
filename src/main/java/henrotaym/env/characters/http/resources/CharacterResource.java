package henrotaym.env.characters.http.resources;

import henrotaym.env.films.http.resources.FilmResource;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CharacterResource {
  private Long id;
  private Long apiCharacterId;
  private String name;
  private String gender;
  private String birthYear;
  private Integer filmCount;
  private Set<FilmResource> films;
}
