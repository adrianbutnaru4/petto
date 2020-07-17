package petto.pettobackend.service.impl;

import org.mapstruct.factory.Mappers;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;
import petto.pettobackend.mapper.UserMapper;
import petto.pettobackend.mapper.generics.AbstractMapper;
import petto.pettobackend.repository.UserRepository;
import petto.pettobackend.service.UserService;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public MongoRepository getRepository() {
    return userRepository;
  }

  @Override
  public AbstractMapper getMapper() {
    return Mappers.getMapper(UserMapper.class);
  }
}
