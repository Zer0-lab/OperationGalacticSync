package henrotaym.env.swapi.http.resources.characters;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import henrotaym.env.swapi.http.resources.SwapiReponse;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CharactersPageResponse extends SwapiReponse<CharacterItem> {}
