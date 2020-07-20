package petto.pettobackend.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import petto.pettobackend.controller.generics.BaseController;
import petto.pettobackend.dto.adoptionsource.post.types.LostAndFoundPostDto;
import petto.pettobackend.service.LostAndFoundPostService;

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
