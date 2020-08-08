package com.petto.core.dto.adoptionsource.post.types;

import com.petto.core.dto.adoptionsource.post.BasePostDto;
import lombok.Data;

@Data
public class LostAndFoundPostDto extends BasePostDto {

  private Long animalId;

  private Long recovererId;

  private String lostAnimalAddress;
}
