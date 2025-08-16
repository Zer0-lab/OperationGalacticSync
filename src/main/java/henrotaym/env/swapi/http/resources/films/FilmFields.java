package henrotaym.env.swapi.http.resources.films;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmFields {
  private String title;

  @JsonProperty("episode_id")
  private Integer episodeId;

  private List<String> characters;
  private List<String> planets;
  private List<String> starships;
  private List<String> vehicles;
  private List<String> species;

  private String url;

  @JsonProperty("release_date")
  private String releaseDate;

  private String director;
  private String producer;
  private String created;
  private String edited;
}
