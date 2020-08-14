package com.petto.core.service.impl;

import com.petto.core.mapper.ShelterMapper;
import com.petto.core.repository.ShelterRepository;
import com.petto.core.service.ShelterService;
import org.mapstruct.factory.Mappers;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

@Service
public class ShelterServiceImpl implements ShelterService {

  private final ShelterRepository shelterRepository;

  public ShelterServiceImpl(ShelterRepository shelterRepository) {
    this.shelterRepository = shelterRepository;
  }

  @Override
  public PagingAndSortingRepository getRepository() {
    return shelterRepository;
  }

  @Override
  public ShelterMapper getMapper() {
    return Mappers.getMapper(ShelterMapper.class);
  }
}
