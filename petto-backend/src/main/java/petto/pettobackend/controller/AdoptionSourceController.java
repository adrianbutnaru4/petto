package petto.pettobackend.controller;

import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import petto.pettobackend.controller.generics.BaseController;
import petto.pettobackend.dto.adoptionsource.AdoptionSourceDto;
import petto.pettobackend.mapper.AdoptionSourceMapper;
import petto.pettobackend.mapper.generics.AbstractMapper;
import petto.pettobackend.service.AdoptionSourceService;

@Slf4j
@RestController
@RequestMapping(AdoptionSourceController.BASE_URL)
public class AdoptionSourceController extends BaseController<AdoptionSourceDto, String> {

  static final String BASE_URL = "adoptionsources";

  private final AdoptionSourceService adoptionSourceService;

  public AdoptionSourceController(AdoptionSourceService adoptionSourceService) {
    this.adoptionSourceService = adoptionSourceService;
  }

  @Override
  public AdoptionSourceService getService() {
    return adoptionSourceService;
  }

  @Override
  public AbstractMapper getMapper() {
    return Mappers.getMapper(AdoptionSourceMapper.class);
  }
}
