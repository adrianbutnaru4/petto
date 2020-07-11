package petto.pettobackend.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import petto.pettobackend.dto.PostDto;
import petto.pettobackend.service.PostService;

import java.util.List;

@Slf4j
@RestController
public class PostController {

  private final PostService postService;

  public PostController(PostService postService) {
    this.postService = postService;
  }

  @PostMapping("/posts")
  public PostDto save() {
    log.info("Saving the post...");
    return postService.save();
  }

  @GetMapping("/posts")
  public List<PostDto> findAll() {
    log.info("Finding all the posts...");
    return postService.findAll();
  }

  @DeleteMapping("/posts")
  public void deleteAll() {
    log.info("Deleting all the posts...");
    postService.deleteAll();
  }
}
