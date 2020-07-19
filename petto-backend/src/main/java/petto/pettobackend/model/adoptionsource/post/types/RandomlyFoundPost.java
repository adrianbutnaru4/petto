package petto.pettobackend.model.adoptionsource.post.types;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import petto.pettobackend.model.adoptionsource.post.Post;
import petto.pettobackend.model.adoptionsource.post.PostType;

import javax.persistence.*;

@Entity
@Table(name = "randomly_found_posts")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RandomlyFoundPost extends Post {

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "post_id", referencedColumnName = "id")
  private Post parentPost;

  private String
      randomlyFoundAnimalAddress; // TODO: investigate appropriate map service to save address set
  // by poster

  private PostType type = PostType.RANDOMLY_FOUND_POST;
}
