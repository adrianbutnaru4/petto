package petto.pettobackend.model.adoptionsource.post.types;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import petto.pettobackend.model.adoptionsource.post.Post;
import petto.pettobackend.model.adoptionsource.post.PostType;
import petto.pettobackend.model.user.User;

import javax.persistence.*;

@Entity
@Table(name = "adoption_posts")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdoptionPost extends Post {

  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  private long id;

  @OneToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "post_id", referencedColumnName = "id")
  private Post parentPost;

  private User adopter;

  private String
      adoptionAddress; // TODO: investigate appropriate map service to save the address (might be
  // the same as the user address or a part of it, e.g. the city)

  @Enumerated(EnumType.STRING)
  private PostType type;
}
