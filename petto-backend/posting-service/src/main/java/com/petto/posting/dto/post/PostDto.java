package com.petto.posting.dto.post;

import com.petto.posting.dto.base.BaseDto;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Map;

@Data
public class PostDto extends BaseDto {

  private Long posterId;

  private PostStatus status;

  private String type;

  private String title;

  private Long validity;

  private Timestamp creationDate;

  private Map<String, Serializable> fields;
}
