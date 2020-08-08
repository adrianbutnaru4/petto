package com.petto.core.dto.animal;

import com.petto.core.dto.post.PostDto;
import com.petto.core.dto.base.BaseDto;
import lombok.Data;

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
