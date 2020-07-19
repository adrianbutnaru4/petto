package petto.pettobackend.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import petto.pettobackend.dto.adoptionsource.post.PostDto;
import petto.pettobackend.dto.adoptionsource.post.PostType;
import petto.pettobackend.dto.adoptionsource.post.types.LostAndFoundPostDto;
import petto.pettobackend.dto.user.UserDto;
import petto.pettobackend.exceptionhandling.exceptions.EntityNotFoundException;
import petto.pettobackend.mapper.LostAndFoundPostMapper;
import petto.pettobackend.mapper.generics.AbstractMapper;
import petto.pettobackend.repository.LostAndFoundPostRepository;
import petto.pettobackend.service.LostAndFoundPostService;
import petto.pettobackend.service.PostService;
import petto.pettobackend.service.UserService;

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
