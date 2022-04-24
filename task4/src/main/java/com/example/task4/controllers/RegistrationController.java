package com.example.task4.controllers;

import com.example.task4.entities.User;
import com.example.task4.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public String getRegistrationPage() {
        return "registration";
    }

    @PostMapping
    public String registration(User user) {
        registrationService.register(user);
        return "redirect:/";
    }
}
