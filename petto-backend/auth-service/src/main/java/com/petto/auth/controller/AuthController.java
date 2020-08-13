package com.petto.auth.controller;

import com.petto.auth.model.UserDto;
import com.petto.auth.security.UserPrincipal;
import com.petto.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/registration")
public class AuthController {

  @Autowired AuthenticationManager authenticationManager;

  @Autowired private UserService userService;

  //    @PostMapping("/login")
  //    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
  //
  //        Authentication authentication = authenticationManager.authenticate(
  //                new UsernamePasswordAuthenticationToken(
  //                        loginRequest.getEmail(),
  //                        loginRequest.getPassword()
  //                )
  //        );
  //
  //        SecurityContextHolder.getContext().setAuthentication(authentication);
  //
  //        String token = tokenProvider.createToken(authentication);
  //        return ResponseEntity.ok(token);
  //    }

  @PostMapping("/signup")
  public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto) {
    final UserDto registered = userService.registerNewUserAccount(userDto);

    return ResponseEntity.ok(registered);
  }

  @GetMapping("/currentUser")
  public ResponseEntity<UserDto> getCurrentUser() {
    UserPrincipal userPrincipal =
        Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
            .map(auth -> (UserPrincipal) auth.getPrincipal())
            .orElseGet(UserPrincipal::new);
    return ResponseEntity.ok(userService.findById(userPrincipal.getId()));
  }
}
