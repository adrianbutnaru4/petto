package com.petto.core.controller;

import com.petto.core.controller.generics.BaseController;
import com.petto.core.controller.util.PatchHelper;
import com.petto.core.dto.animal.AnimalDto;
import com.petto.core.service.AnimalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(AnimalController.BASE_URL)
public class AnimalController extends BaseController<AnimalDto, Long> {

  static final String BASE_URL = "animals";

  private final AnimalService animalService;

  public AnimalController(PatchHelper patchHelper, AnimalService animalService) {
    super(AnimalDto.class, patchHelper);
    this.animalService = animalService;
  }

  @Override
  public AnimalService getService() {
    return animalService;
  }
}
