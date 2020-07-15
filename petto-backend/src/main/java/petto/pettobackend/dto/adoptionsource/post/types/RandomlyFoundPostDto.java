package petto.pettobackend.dto.adoptionsource.post.types;

import petto.pettobackend.dto.adoptionsource.post.PostDto;
import petto.pettobackend.dto.adoptionsource.post.PostType;

public class RandomlyFoundPostDto extends PostDto {

  private String randomlyFoundAnimalAddress;

  private PostType type = PostType.RANDOMLY_FOUND;
}
