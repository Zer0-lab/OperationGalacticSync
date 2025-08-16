package henrotaym.env.swapi.http.resources.characters;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import henrotaym.env.swapi.http.resources.SwapiReponseResource;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CharactersPageResponse extends SwapiReponseResource<CharacterItems> {}
