package com.petto.core.controller;

import com.petto.core.controller.generics.BaseController;
import com.petto.core.controller.util.PatchHelper;
import com.petto.core.dto.adoptionsource.shelter.ShelterDto;
import com.petto.core.service.ShelterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(ShelterController.BASE_URL)
public class ShelterController extends BaseController<ShelterDto, Long> {

  static final String BASE_URL = "shelters";

  private final ShelterService shelterService;

  public ShelterController(PatchHelper patchHelper, ShelterService shelterService) {
    super(ShelterDto.class, patchHelper);
    this.shelterService = shelterService;
  }

  @Override
  public ShelterService getService() {
    return shelterService;
  }
}
