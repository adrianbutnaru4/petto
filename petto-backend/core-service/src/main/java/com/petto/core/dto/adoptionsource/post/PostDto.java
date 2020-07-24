package com.petto.core.dto.adoptionsource.post;

import com.petto.core.dto.adoptionsource.AdoptionSourceDto;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Map;

@Data
public class PostDto extends AdoptionSourceDto {

  private Long posterId;

  private String applicationName;

  private PostType type;

  private PostStatus status;

  private String title;

  private Long validity;

  private Timestamp creationDate;

  private Map<String, Serializable> fields;
}
