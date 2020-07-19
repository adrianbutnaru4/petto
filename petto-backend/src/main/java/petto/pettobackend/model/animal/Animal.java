package petto.pettobackend.model.animal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import petto.pettobackend.model.adoptionsource.post.Post;
import petto.pettobackend.model.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Map;

@Entity
@Table(name = "animals")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Animal extends BaseEntity {

  private String name;

  private String description;

  private AnimalRace race;

  private AnimalSex sex;

  private String photoPath;

  private AnimalStatus status;

  @Transient private Map<String, String> characteristics;

  @OneToOne(mappedBy = "animal")
  private Post post;
}
