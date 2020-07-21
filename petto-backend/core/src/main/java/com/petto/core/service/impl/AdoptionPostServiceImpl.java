package com.petto.core.service.impl;

import com.petto.core.dto.adoptionsource.post.PostDto;
import com.petto.core.dto.adoptionsource.post.PostType;
import com.petto.core.dto.adoptionsource.post.types.AdoptionPostDto;
import com.petto.core.dto.user.UserDto;
import com.petto.core.exceptionhandling.exceptions.EntityNotFoundException;
import com.petto.core.repository.AdoptionPostRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.petto.core.mapper.AdoptionPostMapper;
import com.petto.core.mapper.generics.AbstractMapper;
import com.petto.core.service.AdoptionPostService;
import com.petto.core.service.PostService;
import com.petto.core.service.UserService;

@Service
public class AdoptionPostServiceImpl implements AdoptionPostService {

  private final AdoptionPostRepository adoptionPostRepository;
  private final PostService postService;
  private final UserService userService;

  public AdoptionPostServiceImpl(
      AdoptionPostRepository adoptionPostRepository,
      @Qualifier("postServiceImpl") PostService postService,
      UserService userService) {
    this.adoptionPostRepository = adoptionPostRepository;
    this.postService = postService;
    this.userService = userService;
  }

  @Override
  public AdoptionPostDto saveForPoster(AdoptionPostDto adoptionPostDto, Long posterId) {
    if (userService.exists(posterId)) {
      UserDto poster = (UserDto) userService.findById(posterId);
      adoptionPostDto = (AdoptionPostDto) getPost(adoptionPostDto, posterId);
      adoptionPostDto.setType(PostType.ADOPTION_POST);
      PostDto parentPost = (PostDto) postService.save(adoptionPostDto);
      poster.getPosts().add(parentPost);
      userService.save(poster);
      adoptionPostDto.setParentPostId(parentPost.getId());
      return (AdoptionPostDto) save(adoptionPostDto);
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
    return adoptionPostRepository;
  }

  @Override
  public AbstractMapper getMapper() {
    return Mappers.getMapper(AdoptionPostMapper.class);
  }
}
