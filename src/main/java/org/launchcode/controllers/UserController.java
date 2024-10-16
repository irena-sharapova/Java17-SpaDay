package org.launchcode.controllers;

import org.springframework.ui.Model;

import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")
    public String displayAddUserForm() {
        return "user/add";
    }


    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute User user, String verifyPassword) {

        if (!user.getPassword().equals(verifyPassword)) {
            model.addAttribute("username" , user.getUsername());
            model.addAttribute("email" , user.getEmail());
            model.addAttribute("error", "PASSWORD DO NOT MATCH!");
            return "user/add";
        }
        model.addAttribute("user", user);
        return "user/index";
    }

}


