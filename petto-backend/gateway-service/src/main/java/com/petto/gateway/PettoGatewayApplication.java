package com.petto.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class PettoGatewayApplication {

  public static void main(String[] args) {
    SpringApplication.run(PettoGatewayApplication.class, args);
  }
}

@RestController
class ServiceInstanceRestController {

  private final DiscoveryClient discoveryClient;

  public ServiceInstanceRestController(DiscoveryClient discoveryClient) {
    this.discoveryClient = discoveryClient;
  }

  @RequestMapping("/service-instances/{applicationName}")
  public List<ServiceInstance> serviceInstancesByApplicationName(
      @PathVariable String applicationName) {
    return this.discoveryClient.getInstances(applicationName);
  }
}
