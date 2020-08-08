package com.petto.core.dto.adoptionsource.post;

import com.petto.core.dto.adoptionsource.AdoptionSourceDto;
import com.petto.core.dto.post.PostStatus;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class BasePostDto extends AdoptionSourceDto {

  private Long posterId;

  private PostStatus status;

  private String type;

  private String title;

  private Long validity;

  private Timestamp creationDate;
}
