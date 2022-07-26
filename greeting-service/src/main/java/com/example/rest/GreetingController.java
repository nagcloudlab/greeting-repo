package com.example.rest;

import com.example.service.GreetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
public class GreetingController {

    private final GreetingService greetingService;
    private final RedisTemplate<String, Long> redisTemplate;
//    private Map<String, Long> countMatrix = new HashMap<>();


    @GetMapping(value = "/api/greet/{lang}")
    public ResponseEntity<?> doGreet(@PathVariable String lang) {

        String message = greetingService.getGreetMessage(lang);

//        Long count = countMatrix.get(lang);
//        if (count == null) {
//            count = 1L;
//        } else {
//            count += 1;
//        }
//        countMatrix.put(lang, count);

        ValueOperations<String, Long> valueOperations = redisTemplate.opsForValue();
        Long count = valueOperations.get(lang);
        System.out.println(count);
        if (count == null) {
            count = 1L;
        } else {
            count += 1;
        }
        valueOperations.set(lang, count);
        return ResponseEntity.ok(message + ": " + count);
    }

}
