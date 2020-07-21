package com.petto.core.dto.adoptionsource.post;

import lombok.Data;
import com.petto.core.dto.adoptionsource.AdoptionSourceDto;

import java.sql.Timestamp;

@Data
public class PostDto extends AdoptionSourceDto {

  private Long posterId;

  private Long animalId;

  private String title;

  private PostStatus status;

  private String validity;

  private Timestamp creationDate;
}
