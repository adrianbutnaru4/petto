package petto.pettobackend.dto.user;

import petto.pettobackend.dto.BaseDto;
import petto.pettobackend.model.adoptionsource.post.Post;

import java.util.List;

public class UserDto extends BaseDto {

  private String firstName;

  private String lastName;

  private String address; // TODO: investigate appropriate map service to save address

  private List<Post> posts;
}
