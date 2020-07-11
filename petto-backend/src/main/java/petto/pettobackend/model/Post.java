package petto.pettobackend.model;

import io.github.kaiso.relmongo.annotation.CascadeType;
import io.github.kaiso.relmongo.annotation.FetchType;
import io.github.kaiso.relmongo.annotation.JoinProperty;
import io.github.kaiso.relmongo.annotation.OneToOne;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Post {

  @Id private String id;

  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinProperty(name = "animal")
  private Animal animal;
}
