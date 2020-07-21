package com.petto.core.service.impl;

import com.petto.core.repository.ShelterRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.petto.core.mapper.ShelterMapper;
import com.petto.core.mapper.generics.AbstractMapper;
import com.petto.core.service.ShelterService;

@Service
public class ShelterServiceImpl implements ShelterService {

  private final ShelterRepository shelterRepository;

  public ShelterServiceImpl(ShelterRepository shelterRepository) {
    this.shelterRepository = shelterRepository;
  }

  @Override
  public CrudRepository getRepository() {
    return shelterRepository;
  }

  @Override
  public AbstractMapper getMapper() {
    return Mappers.getMapper(ShelterMapper.class);
  }
}
