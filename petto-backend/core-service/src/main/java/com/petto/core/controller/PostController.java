package com.petto.core.controller;

import com.petto.core.client.PettoPostingClient;
import com.petto.core.controller.generics.BaseController;
import com.petto.core.dto.adoptionsource.post.PostDto;
import com.petto.core.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(PostController.BASE_URL)
public class PostController extends BaseController<PostDto, Long> {

  static final String BASE_URL = "posts";

  private final PostService postService;
  private final PettoPostingClient pettoPostingClient;

  public PostController(PostService postService, PettoPostingClient pettoPostingClient) {
    this.postService = postService;
    this.pettoPostingClient = pettoPostingClient;
  }

  @Override
  public PostDto save(PostDto postDto) {
    return pettoPostingClient.save(postDto);
  }

  @Override
  public PostService getService() {
    return postService;
  }
}
