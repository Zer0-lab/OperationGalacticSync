package henrotaym.env.vehicules.entities;

import henrotaym.env.characters.entities.Character;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "vehicules")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = "characters")
public class Vehicule {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @EqualsAndHashCode.Include
  private Long id;

  @Column(name = "api_vehicle_id", nullable = false, unique = true)
  private Long apiVehicleId;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String model;

  @Column(nullable = false)
  private String manufacturer;

  @Column(name = "cost_in_credits")
  private String costInCredits;

  @Column private String length;

  @Column(name = "max_atmosphering_speed")
  private String maxAtmospheringSpeed;

  @Column private String crew;

  @Column private String passengers;

  @Column(name = "cargo_capacity")
  private String cargoCapacity;

  @Column private String consumables;

  @Column(name = "vehicle_class")
  private String vehicleClass;

  @ManyToMany(mappedBy = "vehicules")
  @Builder.Default
  private Set<Character> characters = new HashSet<>();
}
