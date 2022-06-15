package com.bsuir.analytics.controller;

import com.bsuir.analytics.model.User;
import com.bsuir.analytics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegistrationController {

    private UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUserAccount (@ModelAttribute("user") User user) {
        User check = userService.getUserByName(user.getUsername());
        if(check == null) {
            userService.saveUser(user);
            return "redirect:/registration?success";
        } else
            return "redirect:/registration?error";
   }



}
