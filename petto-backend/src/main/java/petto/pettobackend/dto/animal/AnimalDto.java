package petto.pettobackend.dto.animal;

import lombok.Data;
import petto.pettobackend.dto.adoptionsource.post.PostDto;
import petto.pettobackend.dto.base.BaseDto;

import java.util.Map;

@Data
public class AnimalDto extends BaseDto {

  private String name;

  private String description;

  private AnimalRace race;

  private AnimalSex sex;

  private String photoPath;

  private AnimalStatus status;

  private Map<String, String> characteristics;

  private PostDto post;
}
