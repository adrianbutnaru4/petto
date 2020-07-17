package petto.pettobackend.controller;

import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import petto.pettobackend.controller.generics.BaseController;
import petto.pettobackend.dto.user.UserDto;
import petto.pettobackend.mapper.UserMapper;
import petto.pettobackend.mapper.generics.AbstractMapper;
import petto.pettobackend.model.user.User;
import petto.pettobackend.service.UserService;
import petto.pettobackend.service.generics.AbstractService;

@Slf4j
@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController extends BaseController<UserDto, String> {

  static final String BASE_URL = "users";

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @Override
  public AbstractService<User, UserDto, String> getService() {
    return userService;
  }

  @Override
  public AbstractMapper getMapper() {
    return Mappers.getMapper(UserMapper.class);
  }
}
