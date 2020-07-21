package com.petto.core.mapper.config;

import com.petto.core.dto.adoptionsource.post.PostDto;
import com.petto.core.mapper.config.base.BaseMapperConfig;
import com.petto.core.model.adoptionsource.post.Post;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@MapperConfig
public interface PostMapperConfig extends BaseMapperConfig {

  @InheritConfiguration(name = "mapToBaseEntity")
  @Mappings({
    @Mapping(target = "poster.id", source = "posterId"),
    @Mapping(target = "animal.id", source = "animalId")
  })
  Post mapToPost(PostDto postDto);

  @InheritConfiguration(name = "mapToBaseDto")
  @Mappings({
    @Mapping(target = "posterId", source = "poster.id"),
    @Mapping(target = "animalId", source = "animal.id")
  })
  PostDto mapToPostDto(Post post);
}
