package petto.pettobackend.model.adoptionsource.post.types;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import petto.pettobackend.model.adoptionsource.post.Post;
import petto.pettobackend.model.adoptionsource.post.PostType;

@Data
@Document(collection = "randomly_found_post")
public class RandomlyFoundPost extends Post {

  private String
      randomlyFoundAnimalAddress; // TODO: investigate appropriate map service to save address set
  // by poster

  private PostType type = PostType.RANDOMLY_FOUND;
}
