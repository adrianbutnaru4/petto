package com.petto.auth.client;

import com.petto.auth.model.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "petto-core-service")
public interface PettoUserClient {

    @RequestMapping(method = RequestMethod.GET, value = "/users/findByEmail/{email}", consumes = "application/json")
    UserDto findByEmail(@PathVariable("email") String email);
}
