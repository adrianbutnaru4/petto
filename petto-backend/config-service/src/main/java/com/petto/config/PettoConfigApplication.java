package com.petto.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class PettoConfigApplication {

  public static void main(String[] args) {
    new SpringApplicationBuilder(PettoConfigApplication.class).run(args);
  }
}
