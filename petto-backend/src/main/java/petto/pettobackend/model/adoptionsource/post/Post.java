package petto.pettobackend.model.adoptionsource.post;

import io.github.kaiso.relmongo.annotation.CascadeType;
import io.github.kaiso.relmongo.annotation.FetchType;
import io.github.kaiso.relmongo.annotation.JoinProperty;
import io.github.kaiso.relmongo.annotation.OneToOne;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import petto.pettobackend.model.adoptionsource.AdoptionSource;
import petto.pettobackend.model.animal.Animal;

import java.sql.Timestamp;

@Data
@Document(collection = "post")
public class Post extends AdoptionSource {

  private String posterId;

  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
  @JoinProperty(name = "animal")
  private Animal animal;

  private String title;

  private PostStatus status = PostStatus.OPEN;

  private String validity; // TODO: investigate best object type for validity

  private Timestamp creationDate;
}
