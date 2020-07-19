package petto.pettobackend.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import petto.pettobackend.model.adoptionsource.post.Post;
import petto.pettobackend.model.base.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  private long id;

  private String firstName;

  private String lastName;

  private String address; // TODO: investigate appropriate map service to save address

  @OneToMany(
      targetEntity = Post.class,
      cascade = CascadeType.MERGE,
      fetch = FetchType.LAZY,
      orphanRemoval = true)
  private List<Post> posts;
}
