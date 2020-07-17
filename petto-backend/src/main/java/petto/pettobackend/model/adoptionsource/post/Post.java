package petto.pettobackend.model.adoptionsource.post;

import io.github.kaiso.relmongo.annotation.CascadeType;
import io.github.kaiso.relmongo.annotation.FetchType;
import io.github.kaiso.relmongo.annotation.JoinProperty;
import io.github.kaiso.relmongo.annotation.OneToOne;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import petto.pettobackend.model.adoptionsource.AdoptionSource;
import petto.pettobackend.model.animal.Animal;
import petto.pettobackend.model.user.User;

import java.sql.Timestamp;

@Data
@Document(collection = "post")
public class Post extends AdoptionSource {

  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinProperty(name = "poster")
  private User poster;

  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinProperty(name = "animal")
  private Animal animal;

  private String title;

  private PostStatus status = PostStatus.OPEN;

  private String validity; // TODO: investigate best object type for validity

  private Timestamp creationDate;
}
