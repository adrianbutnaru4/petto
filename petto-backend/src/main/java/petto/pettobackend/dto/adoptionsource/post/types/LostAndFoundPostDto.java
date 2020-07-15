package petto.pettobackend.dto.adoptionsource.post.types;

import petto.pettobackend.dto.adoptionsource.post.PostDto;
import petto.pettobackend.dto.adoptionsource.post.PostType;
import petto.pettobackend.dto.user.UserDto;

public class LostAndFoundPostDto extends PostDto {

  private UserDto recoverer;

  private String lostAnimalAddress;

  private PostType type = PostType.LOST_AND_FOUND;
}
