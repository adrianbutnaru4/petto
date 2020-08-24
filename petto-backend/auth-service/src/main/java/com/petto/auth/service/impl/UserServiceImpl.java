package com.petto.auth.service.impl;

import com.petto.auth.dto.UserDto;
import com.petto.auth.model.User;
import com.petto.auth.repository.UserRepository;
import com.petto.auth.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

  @Autowired private UserRepository userRepository;

  @Autowired private PasswordEncoder passwordEncoder;

  @Autowired private ModelMapper modelMapper;

  @Override
  public UserDto registerNewUserAccount(UserDto userDto) {
    if (emailExists(userDto.getEmail())) {
      throw new RuntimeException(
          "There is an account with that email address: " + userDto.getEmail());
    }
    User user = new User();

    user.setFirstName(userDto.getFirstName());
    user.setLastName(userDto.getLastName());
    user.setPassword(passwordEncoder.encode(userDto.getPassword()));
    user.setEmail(userDto.getEmail());

    return convertToDto(userRepository.save(user));
  }

  @Override
  public UserDto findById(Long id) {
    return userRepository.findById(id).map(this::convertToDto).orElse(null);
  }

  @Override
  public UserDto findByEmail(String email) {
    return userRepository.findByEmail(email).map(this::convertToDto).orElse(null);
  }

  @Override
  public List<UserDto> findAll() {
    return Optional.of(userRepository.findAll())
        .map(users -> users.stream().map(this::convertToDto).collect(Collectors.toList()))
        .orElseGet(ArrayList::new);
  }

  private boolean emailExists(String email) {
    return userRepository.findByEmail(email).isPresent();
  }

  private UserDto convertToDto(User post) {
    return modelMapper.map(post, UserDto.class);
  }
}
