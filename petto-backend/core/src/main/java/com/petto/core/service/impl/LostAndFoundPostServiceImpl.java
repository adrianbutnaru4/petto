package com.petto.core.service.impl;

import com.petto.core.dto.adoptionsource.post.PostDto;
import com.petto.core.dto.adoptionsource.post.PostType;
import com.petto.core.dto.adoptionsource.post.types.LostAndFoundPostDto;
import com.petto.core.dto.user.UserDto;
import com.petto.core.exceptionhandling.exceptions.EntityNotFoundException;
import com.petto.core.repository.LostAndFoundPostRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.petto.core.mapper.LostAndFoundPostMapper;
import com.petto.core.mapper.generics.AbstractMapper;
import com.petto.core.service.LostAndFoundPostService;
import com.petto.core.service.PostService;
import com.petto.core.service.UserService;

@Service
public class LostAndFoundPostServiceImpl implements LostAndFoundPostService {

  private final LostAndFoundPostRepository lostAndFoundPostRepository;
  private final PostService postService;
  private final UserService userService;

  public LostAndFoundPostServiceImpl(
      LostAndFoundPostRepository lostAndFoundPostRepository,
      @Qualifier("postServiceImpl") PostService postService,
      UserService userService) {
    this.lostAndFoundPostRepository = lostAndFoundPostRepository;
    this.postService = postService;
    this.userService = userService;
  }

  @Override
  public LostAndFoundPostDto saveForPoster(LostAndFoundPostDto lostAndFoundPostDto, Long posterId) {
    if (userService.exists(posterId)) {
      UserDto poster = (UserDto) userService.findById(posterId);
      lostAndFoundPostDto = (LostAndFoundPostDto) getPost(lostAndFoundPostDto, posterId);
      lostAndFoundPostDto.setType(PostType.LOST_AND_FOUND_POST);
      PostDto parentPost = (PostDto) postService.save(lostAndFoundPostDto);
      poster.getPosts().add(parentPost);
      userService.save(poster);
      lostAndFoundPostDto.setParentPostId(parentPost.getId());
      return (LostAndFoundPostDto) save(lostAndFoundPostDto);
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
    return lostAndFoundPostRepository;
  }

  @Override
  public AbstractMapper getMapper() {
    return Mappers.getMapper(LostAndFoundPostMapper.class);
  }
}
