package com.petto.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

  private long id;

  @NotNull
  @Size(min = 1, message = "{Size.userDto.firstName}")
  private String firstName;

  @NotNull
  @Size(min = 1, message = "{Size.userDto.lastName}")
  private String lastName;

  @Email
  @NotNull
  @Size(min = 1, message = "{Size.userDto.email}")
  private String email;

  @NotNull private String password;
}
