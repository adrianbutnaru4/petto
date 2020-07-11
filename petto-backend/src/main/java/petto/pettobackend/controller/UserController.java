package petto.pettobackend.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import petto.pettobackend.dto.UserDto;
import petto.pettobackend.service.UserService;

import java.util.List;

@Slf4j
@RestController
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/users")
  public UserDto save() {
    log.info("Saving the user...");
    return userService.save();
  }

  @GetMapping("/users")
  public List<UserDto> findAll() {
    log.info("Finding all the users...");
    return userService.findAll();
  }

  @DeleteMapping("/users")
  public void deleteAll() {
    log.info("Deleting all the users...");
    userService.deleteAll();
  }
}
