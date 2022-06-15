package com.bsuir.analytics.controller;

import com.bsuir.analytics.service.CompanyService;
import com.bsuir.analytics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    private UserService userService;
    private CompanyService companyService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/requested-consutation")
    public String requests(Model model) {
        String orders = "Все заявки переданы в рассмотрение.";
        model.addAttribute("orders", orders);
        return "/requested-consutation";
    }

    @GetMapping("/requested-consultation")
    public String requestsToCheck(Model model) {
        return "/requested-consultation";
    }

    @GetMapping("/statistics")
    public String statistics(Model model) {
        model.addAttribute("countUsers", userService.countAllUsers());
        model.addAttribute("countCompanies", companyService.countAllCompanies());
        return "/statistics";
    }


}
