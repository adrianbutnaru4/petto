package petto.pettobackend.dto.adoptionsource.post.types;

import lombok.Data;
import petto.pettobackend.dto.adoptionsource.post.PostDto;
import petto.pettobackend.dto.adoptionsource.post.PostType;

@Data
public class RandomlyFoundPostDto extends PostDto {

  private PostDto parentPost;

  private String randomlyFoundAnimalAddress;

  private PostType type;
}
