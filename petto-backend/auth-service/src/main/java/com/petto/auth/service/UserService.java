package com.petto.auth.service;

import com.petto.auth.model.UserDto;

public interface UserService {
    UserDto findByEmail(String email);
}
