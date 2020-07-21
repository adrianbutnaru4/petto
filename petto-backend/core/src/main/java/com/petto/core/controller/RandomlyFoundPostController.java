package com.petto.core.controller;

import com.petto.core.controller.generics.BaseController;
import com.petto.core.dto.adoptionsource.post.types.RandomlyFoundPostDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.petto.core.service.RandomlyFoundPostService;

@Slf4j
@RestController
@RequestMapping(RandomlyFoundPostController.BASE_URL)
public class RandomlyFoundPostController extends BaseController<RandomlyFoundPostDto, Long> {

  static final String BASE_URL = "randomlyfoundposts";

  private final RandomlyFoundPostService randomlyFoundPostService;

  public RandomlyFoundPostController(RandomlyFoundPostService randomlyFoundPostService) {
    this.randomlyFoundPostService = randomlyFoundPostService;
  }

  @PostMapping(value = "/saveForPoster")
  @ResponseStatus(HttpStatus.CREATED)
  public RandomlyFoundPostDto saveForPoster(
      @RequestBody RandomlyFoundPostDto dto, @RequestParam("posterId") Long posterId) {
    return getService().saveForPoster(dto, posterId);
  }

  @Override
  public RandomlyFoundPostService getService() {
    return randomlyFoundPostService;
  }
}
