/* (C) 2024 */
package com.anasdidi.mseureka;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@ActiveProfiles("dev")
class MseurekaApplicationTests {

  @Autowired private TestRestTemplate restTemplate;

  @Value("${spring.security.user.name}")
  private String username;

  @Value("${spring.security.user.password}")
  private String password;

  @Test
  @Order(Integer.MIN_VALUE)
  void contextLoads() {
    Assertions.assertNotNull(restTemplate);
  }

  @Test
  void testEurekaUp() {
    ResponseEntity<Object> response =
        restTemplate
            .withBasicAuth(username, password)
            .getForEntity("/eureka/v2/apps", Object.class);
    Assertions.assertEquals(response.getStatusCode().value(), HttpStatus.OK.value());
  }
}
