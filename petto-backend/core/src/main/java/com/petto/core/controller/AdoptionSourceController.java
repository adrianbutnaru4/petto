package com.petto.core.controller;

import com.petto.core.dto.adoptionsource.AdoptionSourceDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.petto.core.controller.generics.BaseController;
import com.petto.core.service.AdoptionSourceService;

@Slf4j
@RestController
@RequestMapping(AdoptionSourceController.BASE_URL)
public class AdoptionSourceController extends BaseController<AdoptionSourceDto, Long> {

  static final String BASE_URL = "adoptionsources";

  private final AdoptionSourceService adoptionSourceService;

  public AdoptionSourceController(AdoptionSourceService adoptionSourceService) {
    this.adoptionSourceService = adoptionSourceService;
  }

  @Override
  public AdoptionSourceService getService() {
    return adoptionSourceService;
  }
}
