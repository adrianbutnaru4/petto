package com.petto.core.service.impl;

import com.petto.core.mapper.AnimalMapper;
import com.petto.core.repository.AnimalRepository;
import com.petto.core.service.AnimalService;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
public class AnimalServiceImpl implements AnimalService {

  private final AnimalRepository animalRepository;

  public AnimalServiceImpl(AnimalRepository animalRepository) {
    this.animalRepository = animalRepository;
  }

  @Override
  public AnimalRepository getRepository() {
    return animalRepository;
  }

  @Override
  public AnimalMapper getMapper() {
    return Mappers.getMapper(AnimalMapper.class);
  }
}
