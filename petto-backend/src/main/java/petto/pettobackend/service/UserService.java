package petto.pettobackend.service;

import petto.pettobackend.dto.UserDto;

import java.util.List;

public interface UserService {

  UserDto save();

  List<UserDto> findAll();

  void deleteAll();
}
