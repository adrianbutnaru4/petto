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
public class AdoptionPost extends Post {

  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinProperty(name = "adopter")
  private User adopter;

  private String
      adoptionAddress; // TODO: investigate appropriate map service to save the address (might be
  // the same as the user address or a part of it, e.g. the city)

  private PostType type = PostType.ADOPTION;
}
