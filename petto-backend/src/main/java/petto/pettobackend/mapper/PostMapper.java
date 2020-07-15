package petto.pettobackend.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import petto.pettobackend.dto.adoptionsource.post.PostDto;
import petto.pettobackend.mapper.generic.AbstractMapper;
import petto.pettobackend.model.adoptionsource.post.Post;

@Mapper
public interface PostMapper extends AbstractMapper<Post, PostDto> {

  PostMapper MAPPER = Mappers.getMapper(PostMapper.class);
}
