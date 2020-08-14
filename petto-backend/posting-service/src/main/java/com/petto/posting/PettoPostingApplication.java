package com.petto.posting;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition(
    servers = {@Server(url = "http://localhost:8060/posting/")},
    info =
        @Info(
            title = "Petto Posting API",
            version = "1.0",
            description = "Documentation Petto Posting API v1.0"))
public class PettoPostingApplication {

  public static void main(String[] args) {
    SpringApplication.run(PettoPostingApplication.class, args);
  }
}
