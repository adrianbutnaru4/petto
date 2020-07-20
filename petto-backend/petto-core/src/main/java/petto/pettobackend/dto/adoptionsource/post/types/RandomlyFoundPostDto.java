package petto.pettobackend.dto.adoptionsource.post.types;

import lombok.Data;
import petto.pettobackend.dto.adoptionsource.post.PostDto;
import petto.pettobackend.dto.adoptionsource.post.PostType;

@Data
public class RandomlyFoundPostDto extends PostDto {

  private Long parentPostId;

  private String randomlyFoundAnimalAddress;

  private PostType type;
}
