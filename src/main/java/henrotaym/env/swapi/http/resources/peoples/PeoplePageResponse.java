package henrotaym.env.swapi.http.resources.peoples;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import henrotaym.env.swapi.http.resources.SwapiReponseResource;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PeoplePageResponse extends SwapiReponseResource<PeopleItems> {}
