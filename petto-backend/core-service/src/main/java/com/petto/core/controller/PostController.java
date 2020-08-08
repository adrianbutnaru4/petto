package com.petto.core.controller;

import com.petto.core.client.PettoPostingClient;
import com.petto.core.dto.post.PostDto;
import com.petto.core.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(PostController.BASE_URL)
public class PostController {

  static final String BASE_URL = "posts";

  private final PostService postService;
  private final PettoPostingClient pettoPostingClient;

  public PostController(PostService postService, PettoPostingClient pettoPostingClient) {
    this.postService = postService;
    this.pettoPostingClient = pettoPostingClient;
  }

  @PostMapping(value = "/save")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<?> save(@RequestBody PostDto postDto) {
    return new ResponseEntity<>(
        postService.getCustomPostDto(pettoPostingClient.save(postDto)), HttpStatus.CREATED);
  }
}
