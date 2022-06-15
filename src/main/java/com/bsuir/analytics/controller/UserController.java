package com.bsuir.analytics.controller;

import com.bsuir.analytics.model.User;
import com.bsuir.analytics.repository.UserRepository;
import com.bsuir.analytics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String viewAllUsers(Model model) {
        model.addAttribute("listUsers", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/add-user")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "add-user";
    }

    @PostMapping("/save-user")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @PostMapping("/update-user/{id}")
    public String updateUser(@PathVariable(value = "id") long id, User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/update-user/{id}")
    public String updateUserForm(@PathVariable(value = "id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "update-user";
    }

    @GetMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable(value = "id") long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }

    @GetMapping("/order-consultation")
    public String orderConsultation(Model model) {
        return "order-consultation";
    }

}
