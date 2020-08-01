package com.petto.auth.security;

import com.petto.auth.model.UserDto;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class UserPrincipal implements UserDetails {

  private Long id;
  private String email;
  private String password;

  public UserPrincipal(Long id, String email, String password) {
    this.id = id;
    this.email = email;
    this.password = password;
  }

  public static UserPrincipal create(UserDto userDto) {
    return new UserPrincipal(
        userDto.getId(),
        userDto.getEmail(),
        userDto.getPassword()
    );
  }

  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return new ArrayList<>();
  }
}
