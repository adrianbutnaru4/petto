package com.petto.posting.service.impl;

import com.petto.posting.mapper.PostMapper;
import com.petto.posting.mapper.generics.AbstractMapper;
import com.petto.posting.repository.PostRepository;
import com.petto.posting.service.PostService;
import org.mapstruct.factory.Mappers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

  private final PostRepository postRepository;

  public PostServiceImpl(PostRepository postRepository) {
    this.postRepository = postRepository;
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
