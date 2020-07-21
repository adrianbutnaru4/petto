package com.petto.core.controller;

import com.petto.core.controller.generics.BaseController;
import com.petto.core.dto.adoptionsource.post.types.LostAndFoundPostDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.petto.core.service.LostAndFoundPostService;

@Slf4j
@RestController
@RequestMapping(LostAndFoundPostController.BASE_URL)
public class LostAndFoundPostController extends BaseController<LostAndFoundPostDto, Long> {

  static final String BASE_URL = "lostandfoundposts";

  private final LostAndFoundPostService lostAndFoundPostService;

  public LostAndFoundPostController(LostAndFoundPostService lostAndFoundPostService) {
    this.lostAndFoundPostService = lostAndFoundPostService;
  }

  @PostMapping(value = "/saveForPoster")
  @ResponseStatus(HttpStatus.CREATED)
  public LostAndFoundPostDto saveForPoster(
      @RequestBody LostAndFoundPostDto dto, @RequestParam("posterId") Long posterId) {
    return getService().saveForPoster(dto, posterId);
  }

  @Override
  public LostAndFoundPostService getService() {
    return lostAndFoundPostService;
  }
}
