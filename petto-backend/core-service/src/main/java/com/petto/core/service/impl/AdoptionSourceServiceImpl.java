package com.petto.core.service.impl;

import com.petto.core.mapper.AdoptionSourceMapper;
import com.petto.core.repository.AdoptionSourceRepository;
import com.petto.core.service.AdoptionSourceService;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
public class AdoptionSourceServiceImpl implements AdoptionSourceService {

  private final AdoptionSourceRepository adoptionSourceRepository;

  public AdoptionSourceServiceImpl(AdoptionSourceRepository adoptionSourceRepository) {
    this.adoptionSourceRepository = adoptionSourceRepository;
  }

  @Override
  public AdoptionSourceRepository getRepository() {
    return adoptionSourceRepository;
  }

  @Override
  public AdoptionSourceMapper getMapper() {
    return Mappers.getMapper(AdoptionSourceMapper.class);
  }
}
