package com.petto.posting.service.impl;

import com.petto.posting.dto.post.PostDto;
import com.petto.posting.dto.post.PostStatus;
import com.petto.posting.mapper.PostMapper;
import com.petto.posting.model.Post;
import com.petto.posting.repository.PostRepository;
import com.petto.posting.service.PostService;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
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
    post = (Post) getRepository().save(post);
    return getMapper().mapToDto(post);
  }

  @Override
  public List<PostDto> findAll(int page, int size, String sortDirection, String sort) {
    return postRepository
        .findAll(PageRequest.of(page, size, Sort.Direction.fromString(sortDirection), sort))
        .getContent().stream()
        .map(getMapper()::mapToDto)
        .collect(Collectors.toList());
  }

  private PostDto getPostDto(PostDto postDto) {
    postDto.setCreationDate(new Timestamp(System.currentTimeMillis()));
    postDto.setStatus(PostStatus.OPEN);
    postDto.setValidity(Long.MAX_VALUE);
    return postDto;
  }

  @Override
  public PagingAndSortingRepository getRepository() {
    return postRepository;
  }

  @Override
  public PostMapper getMapper() {
    return Mappers.getMapper(PostMapper.class);
  }
}
