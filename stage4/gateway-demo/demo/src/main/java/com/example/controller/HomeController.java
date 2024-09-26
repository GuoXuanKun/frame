package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("home")
public class HomeController {
    @RequestMapping("hello")
    public String hello(){
        return "hello";
    }
}
