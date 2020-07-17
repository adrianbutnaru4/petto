package petto.pettobackend.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import petto.pettobackend.mapper.RandomlyFoundPostMapper;
import petto.pettobackend.mapper.generics.AbstractMapper;
import petto.pettobackend.repository.RandomlyFoundPostRepository;
import petto.pettobackend.service.RandomlyFoundPostService;

@Service
public class RandomlyFoundPostServiceImpl implements RandomlyFoundPostService {

  private final RandomlyFoundPostRepository randomlyFoundPostRepository;

  public RandomlyFoundPostServiceImpl(RandomlyFoundPostRepository randomlyFoundPostRepository) {
    this.randomlyFoundPostRepository = randomlyFoundPostRepository;
  }

  @Override
  public MongoRepository getRepository() {
    return randomlyFoundPostRepository;
  }

  @Override
  public AbstractMapper getMapper() {
    return Mappers.getMapper(RandomlyFoundPostMapper.class);
  }
}
