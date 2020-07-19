package petto.pettobackend.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import petto.pettobackend.dto.adoptionsource.post.PostDto;
import petto.pettobackend.dto.adoptionsource.post.PostStatus;
import petto.pettobackend.mapper.PostMapper;
import petto.pettobackend.mapper.generics.AbstractMapper;
import petto.pettobackend.repository.PostRepository;
import petto.pettobackend.service.PostService;

import java.sql.Timestamp;

@Service
public class PostServiceImpl implements PostService {

  private final PostRepository postRepository;

  public PostServiceImpl(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  @Override
  public PostDto getPost(PostDto postDto, Long posterId) {
    postDto.setPosterId(posterId);
    postDto.setCreationDate(new Timestamp(System.currentTimeMillis()));
    postDto.setStatus(PostStatus.OPEN);
    postDto.setValidity("FOREVER");

    return postDto;
  }

  @Override
  public CrudRepository getRepository() {
    return postRepository;
  }

  @Override
  public AbstractMapper getMapper() {
    return Mappers.getMapper(PostMapper.class);
  }
}
