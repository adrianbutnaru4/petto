package com.petto.auth.config;

import com.petto.auth.model.JwtConfig;
import com.petto.auth.security.CustomUserDetailsService;
import com.petto.auth.security.JwtUsernameAndPasswordAuthenticationFilter;
import com.petto.auth.security.PettoAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired private CustomUserDetailsService customUserDetailsService;
  @Autowired AuthenticationManager authenticationManager;

  @Bean
  public JwtConfig jwtConfig() {
    return new JwtConfig();
  }

  @Bean
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManager();
  }

  @Override
  public void configure(AuthenticationManagerBuilder authenticationManagerBuilder)
      throws Exception {
    authenticationManagerBuilder
        .userDetailsService(customUserDetailsService)
        .passwordEncoder(passwordEncoder());
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    final JwtUsernameAndPasswordAuthenticationFilter jwtFilter =
        new JwtUsernameAndPasswordAuthenticationFilter(authenticationManagerBean(), jwtConfig());
    jwtFilter.setFilterProcessesUrl("/login");

    http.cors()
        .and()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .csrf()
        .disable()
        .formLogin()
        .disable()
        .httpBasic()
        .disable()
        .exceptionHandling()
        .authenticationEntryPoint(new PettoAuthenticationEntryPoint())
        .and()
        .addFilter(jwtFilter)
        .authorizeRequests()
        .antMatchers(
            "/",
            "/signup",
            "/error",
            "/swagger-resources/**",
            "/swagger-ui.html",
            "/v2/api-docs",
            "/webjars/**",
            "/favicon.ico",
            "/**/*.png",
            "/**/*.gif",
            "/**/*.svg",
            "/**/*.jpg",
            "/**/*.html",
            "/**/*.css",
            "/**/*.js")
        .permitAll()
        .antMatchers("/login", "/oauth2/**")
        .permitAll()
        .anyRequest()
        .authenticated()

        //                .and()
        //                .oauth2Login()
        //                .authorizationEndpoint()
        //                .baseUri("/oauth2/authorize")
        //                .authorizationRequestRepository(cookieAuthorizationRequestRepository())
        //                .and()
        //                .redirectionEndpoint()
        //                .baseUri("/oauth2/callback/*")
        //                .and()
        //                .userInfoEndpoint()
        //                .userService(customOAuth2UserService)
        //                .and()
        //                .successHandler(oAuth2AuthenticationSuccessHandler)
        //                .failureHandler(oAuth2AuthenticationFailureHandler)
        .and()
        .logout()
        .logoutUrl("/logout")
        .invalidateHttpSession(true)
        .logoutSuccessUrl("/login")
        .deleteCookies("JSESSIONID")
        .and()
        .exceptionHandling()
        .accessDeniedPage("/403");
  }
}
