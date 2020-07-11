package petto.pettobackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import petto.pettobackend.dto.PostDto;
import petto.pettobackend.model.Post;

@Mapper
public interface PostMapper {

  PostMapper MAPPER = Mappers.getMapper(PostMapper.class);

  @Mappings({
    @Mapping(source = "id", target = "id"),
    @Mapping(source = "animalDto", target = "animal")
  })
  Post toModel(PostDto postDto);

  @Mappings({
    @Mapping(source = "id", target = "id"),
    @Mapping(source = "animal", target = "animalDto")
  })
  PostDto toDto(Post post);
}
