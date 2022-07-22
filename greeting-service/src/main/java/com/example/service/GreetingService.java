package com.example.service;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class GreetingService {

    private Map<String, String> matrix = new HashMap<>();


    @PostConstruct
    public void init() {
        matrix.put("en", "hello");
        matrix.put("tn", "vanakkam");
    }

    public String getGreetMessage(String lang) {
        return matrix.get(lang);
    }

}
