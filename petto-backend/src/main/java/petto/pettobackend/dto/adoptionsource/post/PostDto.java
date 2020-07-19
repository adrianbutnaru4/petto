package petto.pettobackend.dto.adoptionsource.post;

import lombok.Data;
import petto.pettobackend.dto.adoptionsource.AdoptionSourceDto;
import petto.pettobackend.dto.animal.AnimalDto;
import petto.pettobackend.dto.user.UserDto;

import java.sql.Timestamp;

@Data
public class PostDto extends AdoptionSourceDto {

  private UserDto poster;

  private AnimalDto animal;

  private String title;

  private PostStatus status;

  private String validity;

  private Timestamp creationDate;
}
