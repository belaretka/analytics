package com.bsuir.analytics.controller;

import com.bsuir.analytics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/information")
    public String information() {
        return "information";
    }



}
