package com.petto.core.service.impl;

import com.petto.core.dto.adoptionsource.post.PostDto;
import com.petto.core.dto.adoptionsource.post.PostStatus;
import com.petto.core.repository.PostRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.petto.core.mapper.PostMapper;
import com.petto.core.mapper.generics.AbstractMapper;
import com.petto.core.service.PostService;

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
