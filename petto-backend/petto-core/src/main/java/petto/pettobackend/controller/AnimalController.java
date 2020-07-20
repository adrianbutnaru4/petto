package petto.pettobackend.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import petto.pettobackend.controller.generics.BaseController;
import petto.pettobackend.dto.animal.AnimalDto;
import petto.pettobackend.service.AnimalService;

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
