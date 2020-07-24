package com.petto.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
public class PettoGatewayApplication {

  private static final Logger LOGGER = LoggerFactory.getLogger(PettoGatewayApplication.class);

  private final RouteDefinitionLocator routeDefinitionLocator;

  public PettoGatewayApplication(RouteDefinitionLocator routeDefinitionLocator) {
    this.routeDefinitionLocator = routeDefinitionLocator;
  }

  public static void main(String[] args) {
    SpringApplication.run(PettoGatewayApplication.class, args);
  }

  @Bean
  public List<GroupedOpenApi> apis() {
    List<GroupedOpenApi> groupedOpenApis = new ArrayList<>();
    List<RouteDefinition> routeDefinitions =
        routeDefinitionLocator.getRouteDefinitions().collectList().block();
    routeDefinitions.stream()
        .filter(routeDefinition -> routeDefinition.getId().matches(".*-service"))
        .forEach(
            routeDefinition -> {
              String name = routeDefinition.getId().replaceAll("-service", "");
              groupedOpenApis.add(
                  GroupedOpenApi.builder().pathsToMatch("/" + name + "/**").setGroup(name).build());
            });
    return groupedOpenApis;
  }
}
