package com.petto.core.controller;

import com.petto.core.controller.generics.BaseController;
import com.petto.core.dto.animal.AnimalDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.petto.core.service.AnimalService;

@Slf4j
@RestController
@RequestMapping(AnimalController.BASE_URL)
public class AnimalController extends BaseController<AnimalDto, Long> {

  static final String BASE_URL = "animals";

  private final AnimalService animalService;

  public AnimalController(AnimalService animalService) {
    this.animalService = animalService;
  }

  @PostMapping(value = "/saveForPost")
  @ResponseStatus(HttpStatus.CREATED)
  public AnimalDto saveForPost(@RequestBody AnimalDto dto, @RequestParam("postId") Long postId) {
    return getService().saveForPost(dto, postId);
  }

  @Override
  public AnimalService getService() {
    return animalService;
  }
}
