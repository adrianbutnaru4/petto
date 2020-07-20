package petto.pettobackend.mapper;

import org.mapstruct.*;
import petto.pettobackend.dto.adoptionsource.post.PostDto;
import petto.pettobackend.dto.base.BaseDto;
import petto.pettobackend.mapper.config.PostMapperConfig;
import petto.pettobackend.mapper.generics.AbstractMapper;
import petto.pettobackend.model.adoptionsource.post.Post;
import petto.pettobackend.model.base.BaseEntity;

@Mapper(config = PostMapperConfig.class)
public abstract class PostMapper implements AbstractMapper {

  @InheritConfiguration(name = "mapToBaseEntity")
  @Mappings({
    @Mapping(target = "poster.id", source = "posterId"),
    @Mapping(target = "animal.id", source = "animalId")
  })
  public abstract Post mapToPost(PostDto postDto);

  @AfterMapping
  public void afterMapToPost(PostDto postDto, @MappingTarget Post post) {
    if (postDto.getAnimalId() == null) {
      post.setAnimal(null);
    }
  }

  @InheritConfiguration(name = "mapToBaseDto")
  @Mappings({
    @Mapping(target = "posterId", source = "poster.id"),
    @Mapping(target = "animalId", source = "animal.id")
  })
  public abstract PostDto mapToPostDto(Post post);

  @AfterMapping
  public void afterMapToPostDto(Post post, @MappingTarget PostDto postDto) {
    if (post.getAnimal() == null) {
      postDto.setAnimalId(null);
    }
  }

  @Override
  public BaseEntity mapToEntity(BaseDto dto) {
    return mapToPost((PostDto) dto);
  }

  @Override
  public BaseDto mapToDto(BaseEntity entity) {
    return mapToPostDto((Post) entity);
  }
}
