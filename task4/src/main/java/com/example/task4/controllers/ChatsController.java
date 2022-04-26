package com.example.task4.controllers;

import com.example.task4.entities.Message;
import com.example.task4.service.MessageService;
import com.example.task4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.List;

@Controller
public class ChatsController {

    private final UserService userService;
    private final MessageService messageService;

    @Autowired
    public ChatsController(UserService userService, MessageService messageService) {
        this.userService = userService;
        this.messageService = messageService;
    }

    @GetMapping("/chat/{chatWith}")
    public String chats(@PathVariable String chatWith, Model model, Principal principal) {
        String currentUser = principal.getName();
        List<Message> chatMessages = messageService.getProfileMessage(chatWith, currentUser);
        chatMessages.addAll(messageService.getProfileMessage(currentUser, chatWith));

        model.addAttribute("messages", chatMessages);
        model.addAttribute("chatWith", chatWith);
        model.addAttribute("currentUser", principal.getName());
        return "chat";
    }



}
