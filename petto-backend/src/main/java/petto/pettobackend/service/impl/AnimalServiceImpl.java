package petto.pettobackend.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import petto.pettobackend.mapper.AnimalMapper;
import petto.pettobackend.mapper.generics.AbstractMapper;
import petto.pettobackend.repository.AnimalRepository;
import petto.pettobackend.service.AnimalService;

@Service
public class AnimalServiceImpl implements AnimalService {

  private final AnimalRepository animalRepository;

  public AnimalServiceImpl(AnimalRepository animalRepository) {
    this.animalRepository = animalRepository;
  }

  @Override
  public MongoRepository getRepository() {
    return animalRepository;
  }

  @Override
  public AbstractMapper getMapper() {
    return Mappers.getMapper(AnimalMapper.class);
  }
}
