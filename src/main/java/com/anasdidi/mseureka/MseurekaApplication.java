/* (C) 2024 */
package com.anasdidi.mseureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableEurekaServer
@EnableWebSecurity
public class MseurekaApplication {

  public static void main(String[] args) {
    SpringApplication.run(MseurekaApplication.class, args);
  }
}
