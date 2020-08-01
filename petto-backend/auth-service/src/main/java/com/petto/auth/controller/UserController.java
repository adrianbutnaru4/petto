package com.petto.auth.controller;

import com.petto.auth.model.UserDto;
import com.petto.auth.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;

@Slf4j
@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {
    static final String BASE_URL = "users";

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public UserDto findByEmail(@PathVariable("email") String email) {
        try {
            return userService.findByEmail(email);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, String.format("User with email '%s' was not found.", email), e);
        }
    }
}
