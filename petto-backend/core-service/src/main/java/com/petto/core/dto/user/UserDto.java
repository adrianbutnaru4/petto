package com.petto.core.dto.user;

import com.petto.core.dto.post.PostDto;
import lombok.Data;
import com.petto.core.dto.base.BaseDto;

import java.util.List;

@Data
public class UserDto extends BaseDto {

  private String firstName;

  private String lastName;

  private String email;

  private String password;

  private String address; // TODO: investigate appropriate map service to save address

  private List<PostDto> posts;
}
