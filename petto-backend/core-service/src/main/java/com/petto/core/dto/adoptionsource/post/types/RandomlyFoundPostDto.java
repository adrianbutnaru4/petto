package com.petto.core.dto.adoptionsource.post.types;

import com.petto.core.dto.adoptionsource.post.BasePostDto;
import lombok.Data;

@Data
public class RandomlyFoundPostDto extends BasePostDto {

  private Long animalId;

  private String randomlyFoundAnimalAddress;
}
