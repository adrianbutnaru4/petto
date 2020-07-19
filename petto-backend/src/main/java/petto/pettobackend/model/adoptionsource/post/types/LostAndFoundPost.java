package petto.pettobackend.model.adoptionsource.post.types;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import petto.pettobackend.model.adoptionsource.post.Post;
import petto.pettobackend.model.adoptionsource.post.PostType;
import petto.pettobackend.model.user.User;

import javax.persistence.*;

@Entity
@Table(name = "lost_and_found_posts")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LostAndFoundPost extends Post {

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "post_id", referencedColumnName = "id")
  private Post parentPost;

  private User recoverer;

  private String
      lostAnimalAddress; // TODO: investigate appropriate map service to save address set by poster

  private PostType type = PostType.LOST_AND_FOUND_POST;
}
