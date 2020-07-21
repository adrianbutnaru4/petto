package com.petto.core.model.user;

import com.petto.core.model.adoptionsource.post.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.petto.core.model.base.BaseEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  private long id;

  private String firstName;

  private String lastName;

  private String address; // TODO: investigate appropriate map service to save address

  @OneToMany(
      targetEntity = Post.class,
      cascade = CascadeType.MERGE,
      fetch = FetchType.LAZY,
      orphanRemoval = true)
  private List<Post> posts;
}
