package com.dogapi.test.web;

import org.apache.coyote.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class DogControllerIntegrationTest {
    // define server random port:
    @LocalServerPort
    private int port;

    // TestRestTemplate is a convenient option
    // when writing integration tests for secured REST endpoints
    // simply autowire a template:
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getAllDogs() {
        // use .getForEntity() of Rest Template to make GET call to url:
        ResponseEntity<List> response =
                this.restTemplate
                        .withBasicAuth("admin", "password") // set credentials before requesting secured endpoints
                        .getForEntity("http://localhost:" + port + "/dogs/", List.class);

        // test if status code response back as OK:
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

    @Test
    public void getADog() {
        ResponseEntity<String> response =
                this.restTemplate
                    .withBasicAuth("admin", "password")
                    .getForEntity("http://localhost:" + port + "/dogs/1/breed", String.class);

        // test if status code return OK:
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }
}
