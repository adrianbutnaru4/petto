package com.petto.auth.service.impl;

import com.petto.auth.client.PettoUserClient;
import com.petto.auth.model.UserDto;
import com.petto.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired private PasswordEncoder passwordEncoder;

  @Autowired private PettoUserClient pettoUserClient;

  @Override
  public UserDto registerNewUserAccount(UserDto userDto) {
    userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));

    return pettoUserClient.save(userDto);
  }

  @Override
  public UserDto findById(Long id) {
    return pettoUserClient.findById(id);
  }
}
