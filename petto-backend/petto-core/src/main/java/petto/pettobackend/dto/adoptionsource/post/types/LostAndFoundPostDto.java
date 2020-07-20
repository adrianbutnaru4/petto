package petto.pettobackend.dto.adoptionsource.post.types;

import lombok.Data;
import petto.pettobackend.dto.adoptionsource.post.PostDto;
import petto.pettobackend.dto.adoptionsource.post.PostType;
import petto.pettobackend.dto.user.UserDto;

@Data
public class LostAndFoundPostDto extends PostDto {

  private Long parentPostId;

  private Long recovererId;

  private String lostAnimalAddress;

  private PostType type;
}
