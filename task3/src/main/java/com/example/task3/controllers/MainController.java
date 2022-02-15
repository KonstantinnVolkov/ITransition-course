package com.example.task3.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class MainController {
    @GetMapping("/")
    public String homePage(){
        return "home";
    }

    @GetMapping("/usersTable")
    public String usersTableAccess(){
        return "This page is for users table";
    }
}
