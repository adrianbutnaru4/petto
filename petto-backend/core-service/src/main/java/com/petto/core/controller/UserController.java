package com.petto.core.controller;

import com.petto.core.controller.generics.BaseController;
import com.petto.core.dto.user.UserDto;
import com.petto.core.exceptionhandling.exceptions.EntityNotFoundException;
import com.petto.core.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController extends BaseController<UserDto, Long> {

  static final String BASE_URL = "users";

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/findByEmail/{email}")
  public ResponseEntity<UserDto> findByEmail(@PathVariable("email") String email) {
    try {
      return ResponseEntity.ok(userService.findByEmail(email));
    } catch (EntityNotFoundException e) {
      return ResponseEntity.notFound().build();
    }
  }

  @Override
  public UserService getService() {
    return userService;
  }
}
