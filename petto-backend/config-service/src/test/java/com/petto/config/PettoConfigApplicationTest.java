package com.petto.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.config.server.environment.EnvironmentController;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(properties = {"spring.profiles.active=native"})
public class PettoConfigApplicationTest {

  @Autowired private EnvironmentController environmentController;

  @Test
  public void contextLoads() {
    assertThat(environmentController).isNotNull();
  }
}
