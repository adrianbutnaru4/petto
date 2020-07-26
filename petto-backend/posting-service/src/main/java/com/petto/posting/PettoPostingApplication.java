package com.petto.posting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PettoPostingApplication {

  public static void main(String[] args) {
    SpringApplication.run(PettoPostingApplication.class, args);
  }
}
