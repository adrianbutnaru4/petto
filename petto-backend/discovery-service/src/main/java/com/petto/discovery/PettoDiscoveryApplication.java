package com.petto.discovery;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PettoDiscoveryApplication {

  public static void main(String[] args) {
    new SpringApplicationBuilder(PettoDiscoveryApplication.class).run(args);
  }
}
