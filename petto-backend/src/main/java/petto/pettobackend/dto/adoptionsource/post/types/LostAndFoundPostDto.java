package petto.pettobackend.dto.adoptionsource.post.types;

import lombok.Data;
import petto.pettobackend.dto.adoptionsource.post.PostDto;
import petto.pettobackend.dto.adoptionsource.post.PostType;
import petto.pettobackend.dto.user.UserDto;

@Data
public class LostAndFoundPostDto extends PostDto {

  private PostDto parentPost;

  private UserDto recoverer;

  private String lostAnimalAddress;

  private PostType type;
}
