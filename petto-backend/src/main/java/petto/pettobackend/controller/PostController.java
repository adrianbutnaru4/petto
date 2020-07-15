package petto.pettobackend.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import petto.pettobackend.controller.generics.BaseController;
import petto.pettobackend.dto.adoptionsource.post.PostDto;
import petto.pettobackend.model.adoptionsource.post.Post;
import petto.pettobackend.service.PostService;
import petto.pettobackend.service.generics.AbstractService;

@Slf4j
@RestController
@RequestMapping(PostController.BASE_URL)
public class PostController extends BaseController<Post, PostDto, String> {

  static final String BASE_URL = "posts";

  private final PostService postService;

  public PostController(PostService postService) {
    this.postService = postService;
  }

  @Override
  public AbstractService<Post, PostDto, String> getService() {
    return postService;
  }
}
