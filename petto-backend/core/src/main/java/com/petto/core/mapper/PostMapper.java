package com.petto.core.mapper;

import com.petto.core.dto.adoptionsource.post.PostDto;
import com.petto.core.dto.base.BaseDto;
import com.petto.core.mapper.config.PostMapperConfig;
import com.petto.core.mapper.generics.AbstractMapper;
import com.petto.core.model.adoptionsource.post.Post;
import com.petto.core.model.base.BaseEntity;
import org.mapstruct.*;

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
