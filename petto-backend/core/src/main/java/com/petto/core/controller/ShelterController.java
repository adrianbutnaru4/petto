package com.petto.core.controller;

import com.petto.core.dto.adoptionsource.shelter.ShelterDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.petto.core.controller.generics.BaseController;
import com.petto.core.service.ShelterService;

@Slf4j
@RestController
@RequestMapping(ShelterController.BASE_URL)
public class ShelterController extends BaseController<ShelterDto, Long> {

  static final String BASE_URL = "shelters";

  private final ShelterService shelterService;

  public ShelterController(ShelterService shelterService) {
    this.shelterService = shelterService;
  }

  @Override
  public ShelterService getService() {
    return shelterService;
  }
}
