package petto.pettobackend.controller;

import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import petto.pettobackend.controller.generics.BaseController;
import petto.pettobackend.dto.adoptionsource.shelter.ShelterDto;
import petto.pettobackend.mapper.ShelterMapper;
import petto.pettobackend.mapper.generics.AbstractMapper;
import petto.pettobackend.service.ShelterService;

@Slf4j
@RestController
@RequestMapping(ShelterController.BASE_URL)
public class ShelterController extends BaseController<ShelterDto, String> {

  static final String BASE_URL = "shelters";

  private final ShelterService shelterService;

  public ShelterController(ShelterService shelterService) {
    this.shelterService = shelterService;
  }

  @Override
  public ShelterService getService() {
    return shelterService;
  }

  @Override
  public AbstractMapper getMapper() {
    return Mappers.getMapper(ShelterMapper.class);
  }
}
