package com.example.task4.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Authentication authentication) {
        if (authentication != null) {
            return "redirect:/messages";
        }
        return "login";
    }

    @GetMapping("/")
    public String home(Authentication authentication) {
        if (authentication != null) {
            return "redirect:/messages";
        } else {
            return "redirect:/login";
        }
    }
}
