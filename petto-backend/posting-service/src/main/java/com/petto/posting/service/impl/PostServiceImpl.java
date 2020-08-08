package com.petto.posting.service.impl;

import com.petto.posting.dto.post.PostDto;
import com.petto.posting.mapper.PostMapper;
import com.petto.posting.mapper.generics.AbstractMapper;
import com.petto.posting.model.Post;
import com.petto.posting.repository.PostRepository;
import com.petto.posting.service.PostService;
import org.mapstruct.factory.Mappers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class PostServiceImpl implements PostService {

  private final PostRepository postRepository;

  public PostServiceImpl(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  @Override
  public PostDto save(PostDto postDto) {
    Post post = (Post) getMapper().mapToEntity(getPostDto(postDto));
    post = (Post) getRepository().save(post);
    return (PostDto) getMapper().mapToDto(post);
  }

  private PostDto getPostDto(PostDto postDto) {
    postDto.setCreationDate(new Timestamp(System.currentTimeMillis()));
    postDto.setValidity(Long.MAX_VALUE);
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
