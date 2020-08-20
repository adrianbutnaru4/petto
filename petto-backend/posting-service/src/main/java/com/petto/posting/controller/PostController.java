package com.petto.posting.controller;

import com.petto.posting.controller.generics.BaseController;
import com.petto.posting.controller.util.PatchHelper;
import com.petto.posting.dto.post.PostDto;
import com.petto.posting.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(PostController.BASE_URL)
public class PostController extends BaseController<PostDto, Long> {

  static final String BASE_URL = "posts";

  private final PostService postService;

  public PostController(PatchHelper patchHelper, PostService postService) {
    super(PostDto.class, patchHelper);
    this.postService = postService;
  }

  @PostMapping(value = "/save")
  @ResponseStatus(HttpStatus.CREATED)
  public PostDto save(@RequestBody PostDto postDto) {
    return postService.save(postDto);
  }

  @GetMapping("/findAllByPosterId")
  public List<PostDto> findAllByPosterId(@RequestParam(name = "posterId") Long posterId) {
    return getService().findAllByPosterId(posterId);
  }

  @GetMapping("/findAllByType")
  public List<PostDto> findAllByType(@RequestParam(name = "type") String type) {
    return getService().findAllByType(type);
  }

  @Override
  public PostService getService() {
    return postService;
  }
}
