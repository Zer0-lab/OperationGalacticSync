package henrotaym.env.swapi.http.resources.peoples;

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
public class PeopleFieldsResource {
  private String name;
  private String gender;

  @JsonProperty("birth_year")
  private String birthYear;

  @JsonProperty("skin_color")
  private String skinColor;

  @JsonProperty("hair_color")
  private String hairColor;

  private String height;

  @JsonProperty("eye_color")
  private String eyeColor;

  private String mass;
  private String homeworld;

  private List<String> species;
  private List<String> films;
  private List<String> vehicles;
  private List<String> starships;

  private String url;
  private String created;
  private String edited;
}
