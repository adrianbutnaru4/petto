// package com.petto.gateway.auth.security;
//
// import com.petto.gateway.auth.model.JwtConfig;
// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.web.authentication.AuthenticationFilter;
// import org.springframework.util.StringUtils;
// import org.springframework.web.filter.OncePerRequestFilter;
//
// import javax.servlet.FilterChain;
// import javax.servlet.ServletException;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
// import java.io.IOException;
// import java.util.List;
// import java.util.stream.Collectors;
//
// public class JwtAuthenticationFilter extends AuthenticationFilter {
//
//    @Autowired
//    private final JwtConfig jwtConfig;
//
//    public JwtAuthenticationFilter(JwtConfig jwtConfig) {
//        this.jwtConfig = jwtConfig;
//    }
//
//    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
// FilterChain filterChain) throws ServletException, IOException {
//        try {
//
//            String bearerToken = request.getHeader("Authorization");
//            if (StringUtils.hasText(bearerToken) && !bearerToken.startsWith("Bearer ")) {
//                filterChain.doFilter(request, response);
//                return;
//            }
//
//            String jwt = bearerToken.replaceFirst("Bearer ", "");
//
//            if (StringUtils.hasText(jwt)) {
//                Claims claims = Jwts.parser()
//                        .setSigningKey(jwtConfig.getSecret().getBytes())
//                        .parseClaimsJws(jwt)
//                        .getBody();
//                String username = claims.getSubject();
//
//                if(username != null) {
//                    @SuppressWarnings("unchecked")
//                    List<String> authorities = (List<String>) claims.get("authorities");
//
//                    UsernamePasswordAuthenticationToken auth = new
// UsernamePasswordAuthenticationToken(
//                            username, null,
// authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
//
//                    SecurityContextHolder.getContext().setAuthentication(auth);
//                }
//
////                UserDetails userDetails = customUserDetailsService.loadUserById(userId);
////                UsernamePasswordAuthenticationToken authentication = new
// UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
////                authentication.setDetails(new
// WebAuthenticationDetailsSource().buildDetails(request));
//
//            }
//        } catch (Exception ex) {
//            logger.error("Could not set user authentication in security context", ex);
//        }
//
//        filterChain.doFilter(request, response);
//    }
// }
