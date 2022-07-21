package com.example.rest;

import com.example.service.GreetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GreetingController {

    private final GreetingService greetingService;

    @GetMapping(value = "/api/greet/{lang}")
    public ResponseEntity<?> doGreet(@PathVariable String lang) {
        String message= greetingService.getGreetMessage(lang);
        return ResponseEntity.ok(message);
    }

}
