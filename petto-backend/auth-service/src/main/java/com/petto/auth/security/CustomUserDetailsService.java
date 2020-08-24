package com.petto.auth.security;

import com.petto.auth.dto.UserDto;
import com.petto.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  @Autowired private UserService userService;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    UserDto user = userService.findByEmail(email);
    UserPrincipal userPrincipal = UserPrincipal.create(user);
    userPrincipal.setAuthorities(getUserAuthorities(user));

    return userPrincipal;
  }

  @Transactional
  public UserDetails loadUserById(Long id) {
    UserDto user = userService.findById(id);
    UserPrincipal userPrincipal = UserPrincipal.create(user);
    userPrincipal.setAuthorities(getUserAuthorities(user));

    return userPrincipal;
  }

  private Set<GrantedAuthority> getUserAuthorities(UserDto user) {
    return user.getRoles().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toSet());
  }
}
