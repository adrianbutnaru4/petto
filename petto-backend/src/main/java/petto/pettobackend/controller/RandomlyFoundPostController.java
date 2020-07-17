package petto.pettobackend.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import petto.pettobackend.controller.generics.BaseController;
import petto.pettobackend.dto.adoptionsource.post.types.RandomlyFoundPostDto;
import petto.pettobackend.model.adoptionsource.post.types.RandomlyFoundPost;
import petto.pettobackend.service.RandomlyFoundPostService;
import petto.pettobackend.service.generics.AbstractService;

@Slf4j
@RestController
@RequestMapping(RandomlyFoundPostController.BASE_URL)
public class RandomlyFoundPostController extends BaseController<RandomlyFoundPostDto, String> {

  static final String BASE_URL = "randomlyfoundposts";

  private final RandomlyFoundPostService randomlyFoundPostService;

  public RandomlyFoundPostController(RandomlyFoundPostService randomlyFoundPostService) {
    this.randomlyFoundPostService = randomlyFoundPostService;
  }

  @Override
  public AbstractService<RandomlyFoundPost, RandomlyFoundPostDto, String> getService() {
    return randomlyFoundPostService;
  }
}
