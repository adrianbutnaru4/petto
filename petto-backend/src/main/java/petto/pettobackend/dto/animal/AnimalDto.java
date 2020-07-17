package petto.pettobackend.dto.animal;

import lombok.Data;
import petto.pettobackend.dto.adoptionsource.post.PostDto;
import petto.pettobackend.dto.base.BaseDto;
import petto.pettobackend.model.animal.AnimalHealthDetails;
import petto.pettobackend.model.animal.AnimalRace;
import petto.pettobackend.model.animal.AnimalSex;
import petto.pettobackend.model.animal.AnimalStatus;

import java.sql.Blob;
import java.util.Map;

@Data
public class AnimalDto extends BaseDto {

  private String name;

  private AnimalRace race;

  private AnimalSex sex;

  private AnimalStatus status;

  private String description;

  private Map<String, Object> characteristics;

  private Blob photo; // TODO: investigate what's the best object type for saving photos

  private String postId;

  private AnimalHealthDetails healthDetails;
}
