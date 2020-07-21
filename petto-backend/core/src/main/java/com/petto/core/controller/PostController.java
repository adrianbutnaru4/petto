package com.petto.core.controller;

import com.petto.core.dto.adoptionsource.post.PostDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.petto.core.controller.generics.BaseController;
import com.petto.core.service.PostService;

@Slf4j
@RestController
@RequestMapping(PostController.BASE_URL)
public class PostController extends BaseController<PostDto, Long> {

  static final String BASE_URL = "posts";

  private final PostService postService;

  public PostController(@Qualifier("postServiceImpl") PostService postService) {
    this.postService = postService;
  }

  @Override
  public PostService getService() {
    return postService;
  }
}
