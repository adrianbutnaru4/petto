package petto.pettobackend.model.animal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import petto.pettobackend.model.adoptionsource.post.Post;
import petto.pettobackend.model.base.BaseEntity;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "animals")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Animal extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  private long id;

  private String name;

  private String description;

  @Enumerated(EnumType.STRING)
  private AnimalRace race;

  @Enumerated(EnumType.STRING)
  private AnimalSex sex;

  private String photoPath;

  @Enumerated(EnumType.STRING)
  private AnimalStatus status;

  @Transient private Map<String, String> characteristics;

  @OneToOne(mappedBy = "animal")
  private Post post;
}