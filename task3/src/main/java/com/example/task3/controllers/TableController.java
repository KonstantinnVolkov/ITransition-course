package com.example.task3.controllers;

import com.example.task3.details.UserDetailsImpl;
import com.example.task3.models.State;
import com.example.task3.models.User;
import com.example.task3.services.UserDetailsServiceImpl;
import com.example.task3.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.PresentationDirection;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/table")
public class TableController {

    private final UserDetailsServiceImpl userDetailsService;
    private final UserService userService;

    @Autowired
    public TableController(UserDetailsServiceImpl userDetailsService, UserService userService) {
        this.userDetailsService = userDetailsService;
        this.userService = userService;
    }

    @GetMapping
    public String getTable(Model model) {
        model.addAttribute("allUsers", userDetailsService.getAllUsersSortedById());
        model.addAttribute("IDs", new String[]{});
        return "table";
    }

    @PostMapping(params = "unblock")
    public String unblockUser(String IDs) {
        if (IDs.isEmpty())
            return "redirect:/table";
        List<Integer> idList = Arrays.asList(IDs.split(",")).stream().map(Integer::parseInt).collect(Collectors.toList());
        for (Integer id : idList) {
            userService.updateStatus(id, State.ACTIVE);
        }
        return "redirect:/table";
    }

    @PostMapping(params = "block")
    public String blockUser(String IDs) {
        if (IDs.isEmpty())
            return "redirect:/table";
        List<Integer> idList = Arrays.asList(IDs.split(",")).stream().map(Integer::parseInt).collect(Collectors.toList());
        for (Integer id : idList) {
            userService.updateStatus(id, State.BANNED);
        }
        return "redirect:/table";
    }

    @PostMapping(params = "delete")
    public String deleteUser(String IDs, Authentication authentication) {
        if (IDs.isEmpty())
            return "redirect:/table";
        List<Integer> idList = Arrays.asList(IDs.split(",")).stream().map(Integer::parseInt).collect(Collectors.toList());
        User currentUser = userService.findByUsername(authentication.getName());

        userService.deleteUsers(idList);
        return "redirect:/table";
    }
}
