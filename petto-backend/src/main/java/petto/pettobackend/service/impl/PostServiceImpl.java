package petto.pettobackend.service.impl;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import petto.pettobackend.mapper.PostMapper;
import petto.pettobackend.mapper.generic.AbstractMapper;
import petto.pettobackend.repository.PostRepository;
import petto.pettobackend.service.PostService;

@Service
public class PostServiceImpl implements PostService {

  private final PostRepository postRepository;

  public PostServiceImpl(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  @Override
  public MongoRepository getRepository() {
    return postRepository;
  }

  @Override
  public AbstractMapper getMapper() {
    return PostMapper.MAPPER;
  }
}
