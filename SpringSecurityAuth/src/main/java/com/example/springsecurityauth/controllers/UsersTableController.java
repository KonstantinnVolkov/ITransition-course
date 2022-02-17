package com.example.springsecurityauth.controllers;

import com.example.springsecurityauth.entities.User;
import com.example.springsecurityauth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UsersTableController {

    @Autowired
    private UserService userService;

    @GetMapping("/users_table")
    private String showUsersTable(Model model){
        model.addAttribute("allUsers", userService.allUsers());
        return "usersTable";
    }
}
