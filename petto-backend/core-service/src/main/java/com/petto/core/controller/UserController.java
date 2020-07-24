package com.petto.core.controller;

import com.petto.core.dto.user.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.petto.core.controller.generics.BaseController;
import com.petto.core.service.UserService;

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
}
