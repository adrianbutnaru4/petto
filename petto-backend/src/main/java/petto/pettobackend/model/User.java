package petto.pettobackend.model;

import io.github.kaiso.relmongo.annotation.FetchType;
import io.github.kaiso.relmongo.annotation.JoinProperty;
import io.github.kaiso.relmongo.annotation.OneToMany;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class User {

  @Id private String id;

  private String firstName;

  private String lastName;

  @OneToMany(fetch = FetchType.EAGER)
  @JoinProperty(name = "posts")
  private List<Post> posts;
}
