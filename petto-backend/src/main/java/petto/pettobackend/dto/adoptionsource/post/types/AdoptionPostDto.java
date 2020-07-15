package petto.pettobackend.dto.adoptionsource.post.types;

import petto.pettobackend.dto.adoptionsource.post.PostDto;
import petto.pettobackend.dto.adoptionsource.post.PostType;
import petto.pettobackend.dto.user.UserDto;

public class AdoptionPostDto extends PostDto {

  private UserDto adopter;

  private String adoptionAddress;

  private PostType type = PostType.ADOPTION;
}
