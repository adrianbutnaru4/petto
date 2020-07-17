package petto.pettobackend.model.user;

import io.github.kaiso.relmongo.annotation.CascadeType;
import io.github.kaiso.relmongo.annotation.FetchType;
import io.github.kaiso.relmongo.annotation.JoinProperty;
import io.github.kaiso.relmongo.annotation.OneToMany;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import petto.pettobackend.model.adoptionsource.post.Post;
import petto.pettobackend.model.base.BaseDocument;

import java.util.List;

@Data
@Document(collection = "user")
public class User extends BaseDocument {

  private String firstName;

  private String lastName;

  private String address; // TODO: investigate appropriate map service to save address

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
  @JoinProperty(name = "posts")
  private List<Post> posts;
}
