package com.example.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping(value = "/api/greet/{lang}")
    public ResponseEntity<?> doGreet(@PathVariable String lang) {
        String message="";
        if (lang.equals("en")) {
            message="vanakkam";
        }
        if (lang.equals("tn")) {
            message="hello";
        }
        return ResponseEntity.ok(message);
    }

}
