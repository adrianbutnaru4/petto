package com.petto.auth.service;

import com.petto.auth.model.UserDto;

public interface UserService {

  UserDto registerNewUserAccount(UserDto accountDto);

  UserDto findById(Long id);
}
