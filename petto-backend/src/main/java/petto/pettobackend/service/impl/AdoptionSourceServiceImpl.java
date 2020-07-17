package petto.pettobackend.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import petto.pettobackend.mapper.AdoptionSourceMapper;
import petto.pettobackend.mapper.generics.AbstractMapper;
import petto.pettobackend.repository.AdoptionSourceRepository;
import petto.pettobackend.service.AdoptionSourceService;

@Service
public class AdoptionSourceServiceImpl implements AdoptionSourceService {

  private final AdoptionSourceRepository adoptionSourceRepository;

  public AdoptionSourceServiceImpl(AdoptionSourceRepository adoptionSourceRepository) {
    this.adoptionSourceRepository = adoptionSourceRepository;
  }

  @Override
  public MongoRepository getRepository() {
    return adoptionSourceRepository;
  }

  @Override
  public AbstractMapper getMapper() {
    return Mappers.getMapper(AdoptionSourceMapper.class);
  }
}
