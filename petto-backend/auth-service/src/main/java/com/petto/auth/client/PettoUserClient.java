package com.petto.auth.client;

import com.petto.auth.model.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "petto-core-service")
public interface PettoUserClient {

    @GetMapping("/users/find")
    UserDto findByEmail(@PathVariable("email") String email);
}
