package com.petto.core.dto.adoptionsource.post.types;

import com.petto.core.dto.adoptionsource.post.PostDto;
import com.petto.core.dto.adoptionsource.post.PostType;
import lombok.Data;

@Data
public class RandomlyFoundPostDto extends PostDto {

  private Long parentPostId;

  private Long animalId;

  private String randomlyFoundAnimalAddress;
}
