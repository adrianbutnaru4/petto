package petto.pettobackend.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import petto.pettobackend.controller.generics.BaseController;
import petto.pettobackend.dto.adoptionsource.post.types.LostAndFoundPostDto;
import petto.pettobackend.model.adoptionsource.post.types.LostAndFoundPost;
import petto.pettobackend.service.LostAndFoundPostService;
import petto.pettobackend.service.generics.AbstractService;

@Slf4j
@RestController
@RequestMapping(LostAndFoundPostController.BASE_URL)
public class LostAndFoundPostController extends BaseController<LostAndFoundPostDto, String> {

  static final String BASE_URL = "lostandfoundposts";

  private final LostAndFoundPostService lostAndFoundPostService;

  public LostAndFoundPostController(LostAndFoundPostService lostAndFoundPostService) {
    this.lostAndFoundPostService = lostAndFoundPostService;
  }

  @Override
  public AbstractService<LostAndFoundPost, LostAndFoundPostDto, String> getService() {
    return lostAndFoundPostService;
  }
}
