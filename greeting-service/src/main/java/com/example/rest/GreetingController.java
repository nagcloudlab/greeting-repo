package com.example.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping(value = "/api/greet/{lang}")
    public String doGreet(@PathVariable String lang) {
        if (lang.equals("en")) {
            return "Vanakkam";
        }
        if (lang.equals("tn")) {
            return "Hello";
        }
        return "Unknown language";
    }

}
