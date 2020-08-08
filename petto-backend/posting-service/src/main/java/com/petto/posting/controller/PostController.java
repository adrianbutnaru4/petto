package com.petto.posting.controller;

import com.petto.posting.controller.generics.BaseController;
import com.petto.posting.dto.post.PostDto;
import com.petto.posting.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
  @PostMapping(value = "/save")
  @ResponseStatus(HttpStatus.CREATED)
  public PostDto save(@RequestBody PostDto postDto) {
    return postService.save(postDto);
  }

  @Override
  public PostService getService() {
    return postService;
  }
}
