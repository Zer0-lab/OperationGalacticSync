package henrotaym.env.swapi.http.resources.films;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import henrotaym.env.swapi.http.resources.PageResponse;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmsPageResponse extends PageResponse<FilmItemResource> {}
