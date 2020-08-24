package com.petto.auth.security;

import com.petto.auth.dto.JwtConfig;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtTokenUtil {

  private static final Logger logger = LoggerFactory.getLogger(JwtTokenUtil.class);

  private final JwtConfig jwtConfig;

  public JwtTokenUtil(JwtConfig jwtConfig) {
    this.jwtConfig = jwtConfig;
  }

  public String createToken(Authentication authentication) {
    UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

    Date now = new Date();
    Date expiryDate = new Date(now.getTime() + jwtConfig.getExpiration());

    return new StringBuilder()
        .append(jwtConfig.getPrefix())
        .append(
            Jwts.builder()
                .setSubject(Long.toString(userPrincipal.getId()))
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS256, jwtConfig.getSecret().getBytes())
                .compact())
        .toString();
  }

  public Long getUserIdFromToken(String token) {
    Claims claims =
        Jwts.parser()
            .setSigningKey(jwtConfig.getSecret().getBytes())
            .parseClaimsJws(token)
            .getBody();

    return Long.parseLong(claims.getSubject());
  }

  public boolean validateToken(String authToken) {
    try {
      Jwts.parser().setSigningKey(jwtConfig.getSecret().getBytes()).parseClaimsJws(authToken);
      return true;
    } catch (SignatureException ex) {
      logger.error("Invalid JWT signature");
    } catch (MalformedJwtException ex) {
      logger.error("Invalid JWT token");
    } catch (ExpiredJwtException ex) {
      logger.error("Expired JWT token");
    } catch (UnsupportedJwtException ex) {
      logger.error("Unsupported JWT token");
    } catch (IllegalArgumentException ex) {
      logger.error("JWT claims string is empty.");
    }
    return false;
  }
}
