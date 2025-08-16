package henrotaym.env.films.entities;

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
@Table(name = "films")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(exclude = "characters")
public class Film {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @EqualsAndHashCode.Include
  private Long id;

  @Column(name = "api_film_id", nullable = false, unique = true)
  private Long apiFilmId;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "episode_id", nullable = false)
  private Integer episodeId;

  // Côté inverse pour éviter deux tables de jointure
  @ManyToMany(mappedBy = "films")
  @Builder.Default
  private Set<Character> characters = new HashSet<>();
}
