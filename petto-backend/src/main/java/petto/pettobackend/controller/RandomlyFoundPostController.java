package petto.pettobackend.controller;

import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import petto.pettobackend.controller.generics.BaseController;
import petto.pettobackend.dto.adoptionsource.post.types.RandomlyFoundPostDto;
import petto.pettobackend.mapper.RandomlyFoundPostMapper;
import petto.pettobackend.mapper.generics.AbstractMapper;
import petto.pettobackend.service.RandomlyFoundPostService;

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

  @Override
  public AbstractMapper getMapper() {
    return Mappers.getMapper(RandomlyFoundPostMapper.class);
  }
}
