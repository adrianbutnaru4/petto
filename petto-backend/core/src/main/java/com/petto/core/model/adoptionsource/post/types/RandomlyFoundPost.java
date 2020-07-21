package com.petto.core.model.adoptionsource.post.types;

import com.petto.core.model.adoptionsource.post.Post;
import com.petto.core.model.adoptionsource.post.PostType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "randomly_found_posts")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RandomlyFoundPost extends Post {

  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  private long id;

  @OneToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "post_id", referencedColumnName = "id")
  private Post parentPost;

  private String
      randomlyFoundAnimalAddress; // TODO: investigate appropriate map service to save address set
  // by poster

  @Enumerated(EnumType.STRING)
  private PostType type;
}
