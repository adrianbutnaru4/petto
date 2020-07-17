package petto.pettobackend.mapper;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import petto.pettobackend.dto.adoptionsource.post.PostDto;
import petto.pettobackend.dto.base.BaseDto;
import petto.pettobackend.mapper.config.PostMapperConfig;
import petto.pettobackend.mapper.generics.AbstractMapper;
import petto.pettobackend.model.adoptionsource.post.Post;
import petto.pettobackend.model.base.BaseDocument;

@Mapper(config = PostMapperConfig.class)
public abstract class PostMapper implements AbstractMapper {

  @InheritConfiguration(name = "mapToBaseDocument")
  @Mappings({})
  public abstract Post mapToPost(PostDto postDto);

  @InheritConfiguration(name = "mapToBaseDto")
  @Mappings({})
  public abstract PostDto mapToPostDto(Post post);

  @Override
  public BaseDocument mapToDocument(BaseDto dto) {
    return mapToPost((PostDto) dto);
  }

  @Override
  public BaseDto mapToDto(BaseDocument document) {
    return mapToPostDto((Post) document);
  }
}
