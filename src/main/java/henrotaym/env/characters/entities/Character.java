package henrotaym.env.characters.entities;

import henrotaym.env.films.entities.Film;
import henrotaym.env.vehicles.entities.Vehicle;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "characters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = "films")
public class Character {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @EqualsAndHashCode.Include
  private Long id;

  @Column(name = "api_character_id", nullable = false, unique = true)
  private Long apiCharacterId;

  @Column(nullable = false)
  private String name;

  @Column private String gender;

  @Column(name = "birth_year")
  private String birthYear;

  @Column(name = "film_count", nullable = false)
  @Builder.Default
  private Integer filmCount = 0;

  @ManyToMany
  @JoinTable(
      name = "character_film",
      joinColumns = @JoinColumn(name = "character_id"),
      inverseJoinColumns = @JoinColumn(name = "film_id"))
  @Builder.Default
  private Set<Film> films = new HashSet<>();

  @ManyToMany
  @JoinTable(
      name = "character_vehicle",
      joinColumns = @JoinColumn(name = "character_id"),
      inverseJoinColumns = @JoinColumn(name = "vehicle_id"))
  @Builder.Default
  private Set<Vehicle> vehicles = new HashSet<>();
}
