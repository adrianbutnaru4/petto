package petto.pettobackend.controller;

import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import petto.pettobackend.controller.generics.BaseController;
import petto.pettobackend.dto.adoptionsource.post.PostDto;
import petto.pettobackend.mapper.PostMapper;
import petto.pettobackend.mapper.generics.AbstractMapper;
import petto.pettobackend.service.PostService;

@Slf4j
@RestController
@RequestMapping(PostController.BASE_URL)
public class PostController extends BaseController<PostDto, String> {

  static final String BASE_URL = "posts";

  private final PostService postService;

  public PostController(@Qualifier("postServiceImpl") PostService postService) {
    this.postService = postService;
  }

  @Override
  public PostService getService() {
    return postService;
  }

  @Override
  public AbstractMapper getMapper() {
    return Mappers.getMapper(PostMapper.class);
  }
}
