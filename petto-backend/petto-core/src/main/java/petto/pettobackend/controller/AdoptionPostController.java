package petto.pettobackend.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import petto.pettobackend.controller.generics.BaseController;
import petto.pettobackend.dto.adoptionsource.post.types.AdoptionPostDto;
import petto.pettobackend.service.AdoptionPostService;

@Slf4j
@RestController
@RequestMapping(AdoptionPostController.BASE_URL)
public class AdoptionPostController extends BaseController<AdoptionPostDto, Long> {

  static final String BASE_URL = "adoptionposts";

  private final AdoptionPostService adoptionPostService;

  public AdoptionPostController(AdoptionPostService adoptionPostService) {
    this.adoptionPostService = adoptionPostService;
  }

  @PostMapping(value = "/saveForPoster")
  @ResponseStatus(HttpStatus.CREATED)
  public AdoptionPostDto saveForPoster(
      @RequestBody AdoptionPostDto dto, @RequestParam("posterId") Long posterId) {
    return getService().saveForPoster(dto, posterId);
  }

  @Override
  public AdoptionPostService getService() {
    return adoptionPostService;
  }
}
