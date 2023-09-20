package com.example.demo2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @Value(value = "${greeting.message}")
    private String message;

    @GetMapping(value = "/")
    public String hello() {
        return message;
    }
}
