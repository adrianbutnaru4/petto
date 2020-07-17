package petto.pettobackend.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import petto.pettobackend.mapper.AdoptionPostMapper;
import petto.pettobackend.mapper.generics.AbstractMapper;
import petto.pettobackend.repository.AdoptionPostRepository;
import petto.pettobackend.service.AdoptionPostService;

@Service
public class AdoptionPostServiceImpl implements AdoptionPostService {

  private final AdoptionPostRepository adoptionPostRepository;

  public AdoptionPostServiceImpl(AdoptionPostRepository adoptionPostRepository) {
    this.adoptionPostRepository = adoptionPostRepository;
  }

  @Override
  public MongoRepository getRepository() {
    return adoptionPostRepository;
  }

  @Override
  public AbstractMapper getMapper() {
    return Mappers.getMapper(AdoptionPostMapper.class);
  }
}
