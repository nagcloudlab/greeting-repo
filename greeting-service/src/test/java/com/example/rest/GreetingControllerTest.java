package com.example.rest;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

// TDD ( Test Driven Devlopment )

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class GreetingControllerTest {

    @Autowired
    private WebTestClient client;

    @Test
    public void enGreet() {
        client
                .get()
                .uri("/api/greet/en")
                .accept(MediaType.TEXT_PLAIN)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(String.class)
                .isEqualTo("hello");

    }

    @Test
    public void tnGreet() {
        client
                .get()
                .uri("/api/greet/tn")
                .accept(MediaType.TEXT_PLAIN)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(String.class)
                .isEqualTo("vanakkam");

    }


}
