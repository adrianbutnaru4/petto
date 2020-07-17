package petto.pettobackend.controller;

import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import petto.pettobackend.controller.generics.BaseController;
import petto.pettobackend.dto.animal.AnimalDto;
import petto.pettobackend.mapper.AnimalMapper;
import petto.pettobackend.mapper.generics.AbstractMapper;
import petto.pettobackend.model.animal.Animal;
import petto.pettobackend.service.AnimalService;
import petto.pettobackend.service.generics.AbstractService;

@Slf4j
@RestController
@RequestMapping(AnimalController.BASE_URL)
public class AnimalController extends BaseController<AnimalDto, String> {

  static final String BASE_URL = "animals";

  private final AnimalService animalService;

  public AnimalController(AnimalService animalService) {
    this.animalService = animalService;
  }

  @Override
  public AbstractService<Animal, AnimalDto, String> getService() {
    return animalService;
  }

  @Override
  public AbstractMapper getMapper() {
    return Mappers.getMapper(AnimalMapper.class);
  }
}
