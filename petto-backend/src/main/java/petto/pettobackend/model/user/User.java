package petto.pettobackend.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import petto.pettobackend.model.adoptionsource.post.Post;
import petto.pettobackend.model.base.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User extends BaseEntity {

  private String firstName;

  private String lastName;

  private String address; // TODO: investigate appropriate map service to save address

  @OneToMany(mappedBy = "poster", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Post> posts;
}
