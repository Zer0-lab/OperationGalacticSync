package henrotaym.env.swapi.http.resources;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SwapiReponse<T> {
  private int count; // total d'éléments
  private int pages; // nombre total de pages
  private String next; // ex: "/api/people?page=2" ou null
  private String previous; // ex: "/api/people?page=1" ou null
  private List<T> results; // éléments de la page
}
