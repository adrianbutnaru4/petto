package petto.pettobackend.mapper;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
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

  @InheritConfiguration(name = "mapToBaseDto")
  @Mappings({
    @Mapping(target = "posterId", source = "poster.id"),
    @Mapping(target = "animalId", source = "animal.id")
  })
  public abstract PostDto mapToPostDto(Post post);

  @Override
  public BaseEntity mapToEntity(BaseDto dto) {
    return mapToPost((PostDto) dto);
  }

  @Override
  public BaseDto mapToDto(BaseEntity entity) {
    return mapToPostDto((Post) entity);
  }
}
