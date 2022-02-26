package com.example.springsecurityauth.controllers;

import com.example.springsecurityauth.entities.User;
import com.example.springsecurityauth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String showRegistrationView(Model model) {
        model.addAttribute("userData", new User());
        return "registration";
    }

    @PostMapping
    public String registerUser(Model model,User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            model.addAttribute("userData", user);
            return "registration";
        }
        userService.register(user);
        return "registration";
        //return REDIRECT + "login";

    }
}
