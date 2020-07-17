package petto.pettobackend.dto.user;

import lombok.Data;
import petto.pettobackend.dto.adoptionsource.post.PostDto;
import petto.pettobackend.dto.base.BaseDto;

import java.util.List;

@Data
public class UserDto extends BaseDto {

  private String firstName;

  private String lastName;

  private String address; // TODO: investigate appropriate map service to save address

  private List<PostDto> posts;
}
