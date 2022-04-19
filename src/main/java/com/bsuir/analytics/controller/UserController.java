package com.bsuir.analytics.controller;

import com.bsuir.analytics.model.User;
import com.bsuir.analytics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listUsers", userService.getAllUsers());
        return "users-management";
    }

    @GetMapping("/addUser")
    public String addUser(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "add-user";
    }

    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable (value = "id") long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "update_user";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable (value ="id") long id) {
        userService.deleteUserById(id);
        return "redirect:/";
    }
}
