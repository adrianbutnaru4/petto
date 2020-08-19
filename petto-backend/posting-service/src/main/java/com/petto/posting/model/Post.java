package com.petto.posting.model;

import com.petto.posting.model.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Map;

@Entity
@Table(name = "posts")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Post extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  private Long id;

  private Long posterId;

  private String status;

  private String type;

  private String title;

  private Long validity;

  private Timestamp creationDate;

  @ElementCollection private Map<String, Serializable> fields;
}
