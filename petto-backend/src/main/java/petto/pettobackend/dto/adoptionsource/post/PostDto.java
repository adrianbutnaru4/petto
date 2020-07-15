package petto.pettobackend.dto.adoptionsource.post;

import petto.pettobackend.dto.adoptionsource.AdoptionSourceDto;
import petto.pettobackend.dto.animal.AnimalDto;
import petto.pettobackend.dto.user.UserDto;

import java.sql.Timestamp;

public class PostDto extends AdoptionSourceDto {

  private UserDto poster;

  private AnimalDto animal;

  private String title;

  private PostStatus status = PostStatus.OPEN;

  private String validity; // TODO: investigate best object type for validity

  private Timestamp creationDate;
}