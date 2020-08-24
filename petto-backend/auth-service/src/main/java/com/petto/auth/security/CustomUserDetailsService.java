package com.petto.auth.security;

import com.petto.auth.dto.UserDto;
import com.petto.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  @Autowired private UserService userService;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    UserDto user = userService.findByEmail(email);

    return UserPrincipal.create(user);
  }

  @Transactional
  public UserDetails loadUserById(Long id) {
    UserDto user = userService.findById(id);

    return UserPrincipal.create(user);
  }
}
