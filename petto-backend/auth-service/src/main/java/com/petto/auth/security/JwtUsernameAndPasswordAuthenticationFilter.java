package com.petto.auth.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.petto.auth.model.JwtConfig;
import com.petto.auth.model.LoginRequest;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class JwtUsernameAndPasswordAuthenticationFilter
    extends UsernamePasswordAuthenticationFilter {

  private static final String REDIS_SET_ACTIVE_SUBJECTS = "active-subjects";

  private final AuthenticationManager authManager;

  private final JwtConfig jwtConfig;

  public JwtUsernameAndPasswordAuthenticationFilter(
      AuthenticationManager authManager, JwtConfig jwtConfig) {
    this.authManager = authManager;
    this.jwtConfig = jwtConfig;

    this.setRequiresAuthenticationRequestMatcher(
        new AntPathRequestMatcher(jwtConfig.getUri(), "POST"));
  }

  @Override
  public Authentication attemptAuthentication(
      HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

    try {

      LoginRequest creds =
          new ObjectMapper().readValue(request.getInputStream(), LoginRequest.class);

      UsernamePasswordAuthenticationToken authToken =
          new UsernamePasswordAuthenticationToken(creds.getUsername(), creds.getPassword());

      return authManager.authenticate(authToken);

    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  protected void successfulAuthentication(
      HttpServletRequest request,
      HttpServletResponse response,
      FilterChain chain,
      Authentication auth)
      throws IOException, ServletException {

    UserPrincipal principal = (UserPrincipal) auth.getPrincipal();

    String token =
        this.generateJwt(
            Long.toString(principal.getId()),
            auth.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList()));

    // RedisUtil.INSTANCE.sadd(REDIS_SET_ACTIVE_SUBJECTS, auth.getName());

    SecurityContextHolder.getContext().setAuthentication(auth);

    response.addHeader(jwtConfig.getHeader(), jwtConfig.getPrefix() + token);
  }

  private String generateJwt(String subject, List<String> roles) {
    long now = System.currentTimeMillis();
    return Jwts.builder()
        .setSubject(subject)
        .claim("authorities", roles)
        .setIssuedAt(new Date(now))
        .setExpiration(new Date(now + jwtConfig.getExpiration() * 1000)) // in milliseconds
        .signWith(SignatureAlgorithm.HS256, jwtConfig.getSecret().getBytes())
        .compact();
  }
}
