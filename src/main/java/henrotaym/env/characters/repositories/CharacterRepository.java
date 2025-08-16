package henrotaym.env.characters.repositories;

import henrotaym.env.characters.entities.Character;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CharacterRepository
    extends JpaRepository<Character, Long>, QuerydslPredicateExecutor<Character> {

  Optional<Character> findByApiCharacterId(Long apiCharacterId);
}
