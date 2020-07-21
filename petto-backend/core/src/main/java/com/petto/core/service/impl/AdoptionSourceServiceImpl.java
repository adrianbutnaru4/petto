package com.petto.core.service.impl;

import com.petto.core.repository.AdoptionSourceRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.petto.core.mapper.AdoptionSourceMapper;
import com.petto.core.mapper.generics.AbstractMapper;
import com.petto.core.service.AdoptionSourceService;

@Service
public class AdoptionSourceServiceImpl implements AdoptionSourceService {

  private final AdoptionSourceRepository adoptionSourceRepository;

  public AdoptionSourceServiceImpl(AdoptionSourceRepository adoptionSourceRepository) {
    this.adoptionSourceRepository = adoptionSourceRepository;
  }

  @Override
  public CrudRepository getRepository() {
    return adoptionSourceRepository;
  }

  @Override
  public AbstractMapper getMapper() {
    return Mappers.getMapper(AdoptionSourceMapper.class);
  }
}
