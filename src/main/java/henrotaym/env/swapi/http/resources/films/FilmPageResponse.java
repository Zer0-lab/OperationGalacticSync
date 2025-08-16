package henrotaym.env.swapi.http.resources.films;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import henrotaym.env.swapi.http.resources.SwapiReponse;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmPageResponse extends SwapiReponse<FilmItem> {}
