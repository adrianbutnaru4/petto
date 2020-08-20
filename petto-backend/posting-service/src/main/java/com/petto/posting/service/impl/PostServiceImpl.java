package com.petto.posting.service.impl;

import com.petto.posting.dto.post.PostDto;
import com.petto.posting.dto.post.PostStatus;
import com.petto.posting.mapper.PostMapper;
import com.petto.posting.model.Post;
import com.petto.posting.repository.PostRepository;
import com.petto.posting.service.PostService;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

  private final PostRepository postRepository;

  public PostServiceImpl(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  @Override
  public PostDto save(PostDto postDto) {
    Post post = getMapper().mapToEntity(getPostDto(postDto));
    post = getRepository().save(post);
    return getMapper().mapToDto(post);
  }

  @Override
  public List<PostDto> findAllByPosterId(Long posterId) {
    List<Post> posts = getRepository().findAllByPosterId(posterId);
    return posts.stream().map(getMapper()::mapToDto).collect(Collectors.toList());
  }

  @Override
  public List<PostDto> findAllByType(String type) {
    List<Post> posts = getRepository().findAllByType(type);
    return posts.stream().map(getMapper()::mapToDto).collect(Collectors.toList());
  }

  private PostDto getPostDto(PostDto postDto) {
    postDto.setCreationDate(new Timestamp(System.currentTimeMillis()));
    postDto.setStatus(PostStatus.OPEN);
    postDto.setValidity(Long.MAX_VALUE);
    return postDto;
  }

  @Override
  public PostRepository getRepository() {
    return postRepository;
  }

  @Override
  public PostMapper getMapper() {
    return Mappers.getMapper(PostMapper.class);
  }
}
