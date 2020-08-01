package com.petto.core.service;

import com.petto.core.dto.user.UserDto;
import com.petto.core.service.generics.AbstractService;

public interface UserService extends AbstractService {
    UserDto findByEmail(String email);
}
