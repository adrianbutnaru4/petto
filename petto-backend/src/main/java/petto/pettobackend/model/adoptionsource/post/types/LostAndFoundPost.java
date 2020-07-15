package petto.pettobackend.model.adoptionsource.post.types;

import io.github.kaiso.relmongo.annotation.CascadeType;
import io.github.kaiso.relmongo.annotation.FetchType;
import io.github.kaiso.relmongo.annotation.JoinProperty;
import io.github.kaiso.relmongo.annotation.OneToOne;
import org.springframework.data.mongodb.core.mapping.Document;
import petto.pettobackend.model.adoptionsource.post.Post;
import petto.pettobackend.model.adoptionsource.post.PostType;
import petto.pettobackend.model.user.User;

@Document
public class LostAndFoundPost extends Post {

  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinProperty(name = "recoverer")
  private User recoverer;

  private String
      lostAnimalAddress; // TODO: investigate appropriate map service to save address set by poster

  private PostType type = PostType.LOST_AND_FOUND;
}
