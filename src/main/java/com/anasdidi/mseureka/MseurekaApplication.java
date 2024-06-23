/* (C) 2024 */
package com.anasdidi.mseureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
@EnableEurekaServer
@EnableWebSecurity
public class MseurekaApplication {

  public static void main(String[] args) {
    SpringApplication.run(MseurekaApplication.class, args);
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    return httpSecurity
        .csrf(csrf -> csrf.disable())
        .httpBasic(httpBasic -> {})
        .authorizeHttpRequests(request -> request.anyRequest().authenticated())
        .build();
  }
}
