package com.petto.auth.service.impl;

import com.petto.auth.model.User;
import com.petto.auth.model.UserDto;
import com.petto.auth.repository.UserRepository;
import com.petto.auth.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDto findByEmail(String email) {
    User foundUser = Optional.ofNullable(userRepository.findByEmail(email)).orElseGet(User::new);
    return new UserDto(foundUser.getId(), foundUser.getFirstName(), foundUser.getLastName(), foundUser.getEmail(), foundUser.getPassword(), null);
  }

}
