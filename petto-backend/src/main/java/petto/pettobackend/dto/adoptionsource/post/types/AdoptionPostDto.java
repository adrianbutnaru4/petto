package petto.pettobackend.dto.adoptionsource.post.types;

import lombok.Data;
import petto.pettobackend.dto.adoptionsource.post.PostDto;
import petto.pettobackend.dto.adoptionsource.post.PostType;

@Data
public class AdoptionPostDto extends PostDto {

  private Long parentPostId;

  private Long adopterId;

  private String adoptionAddress;

  private PostType type;
}
