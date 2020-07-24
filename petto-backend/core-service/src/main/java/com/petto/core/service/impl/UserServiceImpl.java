package com.petto.core.service.impl;

import com.petto.core.mapper.UserMapper;
import com.petto.core.repository.UserRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import com.petto.core.mapper.generics.AbstractMapper;
import com.petto.core.service.UserService;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public CrudRepository getRepository() {
    return userRepository;
  }

  @Override
  public AbstractMapper getMapper() {
    return Mappers.getMapper(UserMapper.class);
  }
}
