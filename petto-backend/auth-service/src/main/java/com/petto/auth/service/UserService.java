package com.petto.auth.service;

import com.petto.auth.dto.UserDto;

import java.util.List;

public interface UserService {

  UserDto registerNewUserAccount(UserDto accountDto);

  UserDto findById(Long id);

  UserDto findByEmail(String email);

  List<UserDto> findAll();
}
