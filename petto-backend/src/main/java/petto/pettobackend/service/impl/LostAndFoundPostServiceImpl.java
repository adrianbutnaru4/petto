package petto.pettobackend.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import petto.pettobackend.mapper.LostAndFoundPostMapper;
import petto.pettobackend.mapper.generics.AbstractMapper;
import petto.pettobackend.repository.LostAndFoundPostRepository;
import petto.pettobackend.service.LostAndFoundPostService;

@Service
public class LostAndFoundPostServiceImpl implements LostAndFoundPostService {

  private final LostAndFoundPostRepository lostAndFoundPostRepository;

  public LostAndFoundPostServiceImpl(LostAndFoundPostRepository lostAndFoundPostRepository) {
    this.lostAndFoundPostRepository = lostAndFoundPostRepository;
  }

  @Override
  public MongoRepository getRepository() {
    return lostAndFoundPostRepository;
  }

  @Override
  public AbstractMapper getMapper() {
    return Mappers.getMapper(LostAndFoundPostMapper.class);
  }
}
