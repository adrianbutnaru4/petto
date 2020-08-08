package com.petto.core.dto.adoptionsource.post.types;

import com.petto.core.dto.adoptionsource.post.BasePostDto;
import lombok.Data;

@Data
public class AdoptionPostDto extends BasePostDto {

  private Long animalId;

  private Long adopterId;

  private String adoptionAddress;
}
