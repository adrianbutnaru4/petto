package com.petto.core.service.impl;

import com.petto.core.dto.adoptionsource.post.PostDto;
import com.petto.core.dto.adoptionsource.post.PostType;
import com.petto.core.dto.adoptionsource.post.types.RandomlyFoundPostDto;
import com.petto.core.dto.user.UserDto;
import com.petto.core.exceptionhandling.exceptions.EntityNotFoundException;
import com.petto.core.repository.RandomlyFoundPostRepository;
import com.petto.core.service.RandomlyFoundPostService;
import com.petto.core.service.UserService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.petto.core.mapper.RandomlyFoundPostMapper;
import com.petto.core.mapper.generics.AbstractMapper;
import com.petto.core.service.PostService;

@Service
public class RandomlyFoundPostServiceImpl implements RandomlyFoundPostService {

  private final RandomlyFoundPostRepository randomlyFoundPostRepository;
  private final PostService postService;
  private final UserService userService;

  public RandomlyFoundPostServiceImpl(
      RandomlyFoundPostRepository randomlyFoundPostRepository,
      @Qualifier("postServiceImpl") PostService postService,
      UserService userService) {
    this.randomlyFoundPostRepository = randomlyFoundPostRepository;
    this.postService = postService;
    this.userService = userService;
  }

  @Override
  public RandomlyFoundPostDto saveForPoster(
      RandomlyFoundPostDto randomlyFoundPostDto, Long posterId) {
    if (userService.exists(posterId)) {
      UserDto poster = (UserDto) userService.findById(posterId);
      randomlyFoundPostDto = (RandomlyFoundPostDto) getPost(randomlyFoundPostDto, posterId);
      randomlyFoundPostDto.setType(PostType.RANDOMLY_FOUND_POST);
      PostDto parentPost = (PostDto) postService.save(randomlyFoundPostDto);
      poster.getPosts().add(parentPost);
      userService.save(poster);
      randomlyFoundPostDto.setParentPostId(parentPost.getId());
      return (RandomlyFoundPostDto) save(randomlyFoundPostDto);
    } else {
      throw new EntityNotFoundException();
    }
  }

  @Override
  public PostDto getPost(PostDto postDto, Long posterId) {
    return postService.getPost(postDto, posterId);
  }

  @Override
  public CrudRepository getRepository() {
    return randomlyFoundPostRepository;
  }

  @Override
  public AbstractMapper getMapper() {
    return Mappers.getMapper(RandomlyFoundPostMapper.class);
  }
}
