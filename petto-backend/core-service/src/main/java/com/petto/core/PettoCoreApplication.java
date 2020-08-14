package com.petto.core;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@OpenAPIDefinition(
    servers = {@Server(url = "http://localhost:8060/core/")},
    info =
        @Info(
            title = "Petto Core API",
            version = "1.0",
            description = "Documentation Petto Core API v1.0"))
public class PettoCoreApplication {

  public static void main(String[] args) {
    SpringApplication.run(PettoCoreApplication.class, args);
  }
}
