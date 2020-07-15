package petto.pettobackend.model.user;

import io.github.kaiso.relmongo.annotation.FetchType;
import io.github.kaiso.relmongo.annotation.JoinProperty;
import io.github.kaiso.relmongo.annotation.OneToMany;
import org.springframework.data.mongodb.core.mapping.Document;
import petto.pettobackend.model.BaseDocument;
import petto.pettobackend.model.adoptionsource.post.Post;

import java.util.List;

@Document
public class User extends BaseDocument {

  private String firstName;

  private String lastName;

  private String address; // TODO: investigate appropriate map service to save address

  @OneToMany(fetch = FetchType.EAGER)
  @JoinProperty(name = "posts")
  private List<Post> posts;
}
