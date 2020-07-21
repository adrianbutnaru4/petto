package com.petto.core.dto.adoptionsource.post.types;

import com.petto.core.dto.adoptionsource.post.PostDto;
import com.petto.core.dto.adoptionsource.post.PostType;
import lombok.Data;

@Data
public class LostAndFoundPostDto extends PostDto {

  private Long parentPostId;

  private Long recovererId;

  private String lostAnimalAddress;

  private PostType type;
}
