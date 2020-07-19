package petto.pettobackend.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import petto.pettobackend.dto.adoptionsource.post.PostDto;
import petto.pettobackend.dto.adoptionsource.post.PostType;
import petto.pettobackend.dto.adoptionsource.post.types.AdoptionPostDto;
import petto.pettobackend.dto.user.UserDto;
import petto.pettobackend.exceptionhandling.exceptions.EntityNotFoundException;
import petto.pettobackend.mapper.AdoptionPostMapper;
import petto.pettobackend.mapper.generics.AbstractMapper;
import petto.pettobackend.repository.AdoptionPostRepository;
import petto.pettobackend.service.AdoptionPostService;
import petto.pettobackend.service.PostService;
import petto.pettobackend.service.UserService;

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
