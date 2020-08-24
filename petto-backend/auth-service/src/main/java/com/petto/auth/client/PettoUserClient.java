package com.petto.auth.client;

import com.petto.auth.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "petto-core-service")
public interface PettoUserClient {

  @GetMapping(value = "/users/findByEmail/{email}", consumes = "application/json")
  UserDto findByEmail(@PathVariable("email") String email);

  @PostMapping(value = "/users/save", consumes = "application/json")
  UserDto save(@RequestBody UserDto userDto);

  @GetMapping(value = "/users/{id}", consumes = "application/json")
  UserDto findById(@PathVariable("id") Long id);
}
