package henrotaym.env.database.factories;

import henrotaym.env.characters.entities.Character;
import henrotaym.env.characters.repositories.CharacterRepository;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;
import lombok.Getter;
import net.datafaker.Faker;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component("characterFactory")
@Profile("test")
@Getter
public class CharacterFactory extends EntityFactory<Character> {

  private final CharacterRepository characterRepository;
  private final AtomicLong idGenerator = new AtomicLong(1000);

  public CharacterFactory(Faker faker, CharacterRepository repository) {
    super(faker, repository);
    this.characterRepository = repository;
  }

  @Override
  protected Character entity() {
    return new Character();
  }

  @Override
  protected void attributes(Character character) {
    character.setApiCharacterId(idGenerator.getAndIncrement());
    character.setName(faker.starWars().character());
    character.setGender(faker.demographic().sex().toLowerCase());
    character.setBirthYear(faker.number().numberBetween(1, 100) + "BBY");
    character.setFilmCount(0);
  }

  public Character createFromBuilder(Consumer<Character.CharacterBuilder> callback) {
    var builder = Character.builder().filmCount(0);
    callback.accept(builder);
    return characterRepository.save(builder.build());
  }

  public Character createWithApiId(long apiCharacterId) {
    return createFromBuilder(b -> b.apiCharacterId(apiCharacterId));
  }
}
