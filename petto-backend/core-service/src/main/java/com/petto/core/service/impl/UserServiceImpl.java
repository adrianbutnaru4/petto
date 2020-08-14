package com.petto.core.service.impl;

import com.petto.core.dto.user.UserDto;
import com.petto.core.mapper.UserMapper;
import com.petto.core.repository.UserRepository;
import com.petto.core.service.UserService;
import org.mapstruct.factory.Mappers;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDto findByEmail(String email) {
    return getMapper().mapToDto(userRepository.findByEmail(email));
  }

  @Override
  public PagingAndSortingRepository getRepository() {
    return userRepository;
  }

  @Override
  public UserMapper getMapper() {
    return Mappers.getMapper(UserMapper.class);
  }
}
