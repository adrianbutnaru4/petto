package petto.pettobackend.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import petto.pettobackend.dto.adoptionsource.post.PostDto;
import petto.pettobackend.dto.adoptionsource.post.PostType;
import petto.pettobackend.dto.adoptionsource.post.types.RandomlyFoundPostDto;
import petto.pettobackend.dto.user.UserDto;
import petto.pettobackend.exceptionhandling.exceptions.EntityNotFoundException;
import petto.pettobackend.mapper.RandomlyFoundPostMapper;
import petto.pettobackend.mapper.generics.AbstractMapper;
import petto.pettobackend.repository.RandomlyFoundPostRepository;
import petto.pettobackend.service.PostService;
import petto.pettobackend.service.RandomlyFoundPostService;
import petto.pettobackend.service.UserService;

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
