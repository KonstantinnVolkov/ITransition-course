package com.example.tests.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @GetMapping("/authenticated")
    public String getAuthenticatedPage(){
        return "authenticated";
    }
}
