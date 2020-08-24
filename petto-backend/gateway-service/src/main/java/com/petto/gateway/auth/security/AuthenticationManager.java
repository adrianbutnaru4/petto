package com.petto.gateway.auth.security;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AuthenticationManager implements ReactiveAuthenticationManager {

  @Autowired private JwtUtil jwtUtil;

  @Override
  @SuppressWarnings("unchecked")
  public Mono<Authentication> authenticate(Authentication authentication) {
    String authToken = authentication.getCredentials().toString();

    try {
      if (!jwtUtil.validateToken(authToken)) {
        return Mono.empty();
      }
      Claims claims = jwtUtil.getAllClaimsFromToken(authToken);
      List<SimpleGrantedAuthority> authorities =
          Optional.ofNullable(claims.get("roles", List.class))
              .map(roles -> (List<String>) roles)
              .map(
                  roles ->
                      roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()))
              .orElseGet(ArrayList::new);

      return Mono.just(
          new UsernamePasswordAuthenticationToken(claims.getSubject(), null, authorities));
    } catch (Exception e) {
      return Mono.empty();
    }
  }
}
