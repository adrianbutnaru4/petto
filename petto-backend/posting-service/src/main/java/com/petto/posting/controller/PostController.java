package com.petto.posting.controller;

import com.petto.posting.controller.generics.BaseController;
import com.petto.posting.dto.PostDto;
import com.petto.posting.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(PostController.BASE_URL)
public class PostController extends BaseController<PostDto, Long> {

  static final String BASE_URL = "posts";

  private final PostService postService;

  public PostController(PostService postService) {
    this.postService = postService;
  }

  @Override
  public PostService getService() {
    return postService;
  }
}
