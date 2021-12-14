package com.example.translatorapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping (path = "test")
    public String read(){
        return "123";
    }
}
