package petto.pettobackend.controller;

import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import petto.pettobackend.controller.generics.BaseController;
import petto.pettobackend.dto.user.UserDto;
import petto.pettobackend.mapper.UserMapper;
import petto.pettobackend.mapper.generics.AbstractMapper;
import petto.pettobackend.service.UserService;

@Slf4j
@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController extends BaseController<UserDto, Long> {

  static final String BASE_URL = "users";

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @Override
  public UserService getService() {
    return userService;
  }

  @Override
  public AbstractMapper getMapper() {
    return Mappers.getMapper(UserMapper.class);
  }
}
