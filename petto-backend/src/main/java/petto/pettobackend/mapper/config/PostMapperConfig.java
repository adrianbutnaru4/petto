package petto.pettobackend.mapper.config;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import petto.pettobackend.dto.adoptionsource.post.PostDto;
import petto.pettobackend.mapper.config.base.BaseMapperConfig;
import petto.pettobackend.model.adoptionsource.post.Post;

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
