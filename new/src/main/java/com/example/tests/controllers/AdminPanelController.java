package com.example.tests.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminPanelController {

    @GetMapping("/admin_panel")
    public String getAdminPage(){
        return "adminPanel";
    }
}
