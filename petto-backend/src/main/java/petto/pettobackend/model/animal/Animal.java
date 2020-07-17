package petto.pettobackend.model.animal;

import io.github.kaiso.relmongo.annotation.FetchType;
import io.github.kaiso.relmongo.annotation.JoinProperty;
import io.github.kaiso.relmongo.annotation.OneToOne;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import petto.pettobackend.model.adoptionsource.post.Post;
import petto.pettobackend.model.base.BaseDocument;

import java.sql.Blob;
import java.util.Map;

@Data
@Document(collection = "animal")
public class Animal extends BaseDocument {

  private String name;

  private AnimalRace race;

  private AnimalSex sex;

  private AnimalStatus status;

  private String description;

  private Map<String, Object> characteristics;

  private Blob photo; // TODO: investigate what's the best object type for saving photos

  @OneToOne(mappedBy = "animal", fetch = FetchType.LAZY)
  private Post post;

  @OneToOne(fetch = FetchType.EAGER)
  @JoinProperty(name = "healthDetails")
  private AnimalHealthDetails healthDetails;
}
