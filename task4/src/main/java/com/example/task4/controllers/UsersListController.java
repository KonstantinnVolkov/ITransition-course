package com.example.task4.controllers;

import com.example.task4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class UsersListController {

    private final UserService userService;

    @Autowired
    public UsersListController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getUsersList(Principal principal, Model model) {
        model.addAttribute("currentUser", principal.getName());
        model.addAttribute("users", userService.getAllUsers());
        return "usersList";
    }
}
