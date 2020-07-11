package petto.pettobackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

  private String id;

  private String firstName;

  private String lastName;

  private List<PostDto> postDtos;
}
