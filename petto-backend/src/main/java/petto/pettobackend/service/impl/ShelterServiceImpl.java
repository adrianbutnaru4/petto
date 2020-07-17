package petto.pettobackend.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import petto.pettobackend.mapper.ShelterMapper;
import petto.pettobackend.mapper.generics.AbstractMapper;
import petto.pettobackend.repository.ShelterRepository;
import petto.pettobackend.service.ShelterService;

@Service
public class ShelterServiceImpl implements ShelterService {

  private final ShelterRepository shelterRepository;

  public ShelterServiceImpl(ShelterRepository shelterRepository) {
    this.shelterRepository = shelterRepository;
  }

  @Override
  public MongoRepository getRepository() {
    return shelterRepository;
  }

  @Override
  public AbstractMapper getMapper() {
    return Mappers.getMapper(ShelterMapper.class);
  }
}
