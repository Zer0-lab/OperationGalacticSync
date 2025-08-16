package henrotaym.env.swapi.http.resources.films;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import henrotaym.env.swapi.http.resources.SwapiReponseResource;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmPageResponse extends SwapiReponseResource<FilmItems> {}
