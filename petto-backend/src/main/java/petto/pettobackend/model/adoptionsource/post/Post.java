package petto.pettobackend.model.adoptionsource.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import petto.pettobackend.model.adoptionsource.AdoptionSource;
import petto.pettobackend.model.animal.Animal;
import petto.pettobackend.model.user.User;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "posts")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Post extends AdoptionSource {

  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  private long id;

  @ManyToOne(fetch = FetchType.LAZY)
  private User poster;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinTable(
      name = "post_animal",
      joinColumns = {@JoinColumn(name = "id", referencedColumnName = "id")},
      inverseJoinColumns = {@JoinColumn(name = "id", referencedColumnName = "id")})
  private Animal animal;

  private String title;

  @Enumerated(EnumType.STRING)
  private PostStatus status;

  private String validity; // TODO: investigate best object type for validity

  private Timestamp creationDate;
}
