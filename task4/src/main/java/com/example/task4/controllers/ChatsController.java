package com.example.task4.controllers;

import com.example.task4.entities.User;
import com.example.task4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ChatsController {

    private final UserService userService;

    @Autowired
    public ChatsController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/im")
    public String chats(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "chats";
    }



}
