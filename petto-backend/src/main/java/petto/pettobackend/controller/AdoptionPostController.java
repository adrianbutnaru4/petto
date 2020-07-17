package petto.pettobackend.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import petto.pettobackend.controller.generics.BaseController;
import petto.pettobackend.dto.adoptionsource.post.types.AdoptionPostDto;
import petto.pettobackend.model.adoptionsource.post.types.AdoptionPost;
import petto.pettobackend.service.AdoptionPostService;
import petto.pettobackend.service.generics.AbstractService;

@Slf4j
@RestController
@RequestMapping(AdoptionPostController.BASE_URL)
public class AdoptionPostController extends BaseController<AdoptionPostDto, String> {

  static final String BASE_URL = "adoptionposts";

  private final AdoptionPostService adoptionPostService;

  public AdoptionPostController(AdoptionPostService adoptionPostService) {
    this.adoptionPostService = adoptionPostService;
  }

  @Override
  public AbstractService<AdoptionPost, AdoptionPostDto, String> getService() {
    return adoptionPostService;
  }
}
