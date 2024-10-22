package com.petto.posting.mapper;

import com.petto.posting.dto.base.BaseDto;
import com.petto.posting.dto.post.PostDto;
import com.petto.posting.mapper.config.PostMapperConfig;
import com.petto.posting.mapper.generics.AbstractMapper;
import com.petto.posting.model.Post;
import com.petto.posting.model.base.BaseEntity;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

@Mapper(config = PostMapperConfig.class)
public abstract class PostMapper implements AbstractMapper {

  @InheritConfiguration(name = "mapToBaseEntity")
  @Mappings({})
  public abstract Post mapToPost(PostDto postDto);

  @InheritConfiguration(name = "mapToBaseDto")
  @Mappings({})
  public abstract PostDto mapToPostDto(Post post);

  @Override
  public Post mapToEntity(BaseDto dto) {
    return mapToPost((PostDto) dto);
  }

  @Override
  public PostDto mapToDto(BaseEntity entity) {
    return mapToPostDto((Post) entity);
  }
}
