package com.petto.core.dto.adoptionsource.post.types;

import com.petto.core.dto.adoptionsource.post.PostDto;
import com.petto.core.dto.adoptionsource.post.PostType;
import lombok.Data;

@Data
public class AdoptionPostDto extends PostDto {

  private Long parentPostId;

  private Long adopterId;

  private String adoptionAddress;

  private PostType type;
}
