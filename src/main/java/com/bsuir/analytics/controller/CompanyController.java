package com.bsuir.analytics.controller;

import com.bsuir.analytics.model.Company;
import com.bsuir.analytics.model.User;
import com.bsuir.analytics.service.CompanyService;
import com.bsuir.analytics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CompanyController {

    private CompanyService companyService;

    @Autowired
    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }


    @GetMapping("/companies")
    public String viewCompaniesPage(Model model){
        model.addAttribute("listCompanies", companyService.getAllCompanies());
        return "companies";
    }

    @GetMapping("/users-company")
    public String viewUsersCompaniesPage(Model model) {
        return null;
    }

    @GetMapping("/add-company")
    public String addCompanyForm(Model model){
        Company company = new Company();
        model.addAttribute("company", company);
        return "add-company";
    }

    @PostMapping("/save-company")
    public String saveCompany(@ModelAttribute("company") Company company) {
        companyService.saveCompany(company);
        return "redirect:/companies";
    }
    @PostMapping("/update-company/{id}")
    public String updateCompany(@PathVariable(value="id") long id, Company company) {
        companyService.saveCompany(company);
        return "redirect:/companies";
    }

    @GetMapping("/update-company/{id}")
    public String updateCompany(@PathVariable(value = "id") long id, Model model) {
        Company company = companyService.getCompanyById(id);
        model.addAttribute("company", company);
        return "update-company";
    }

    @GetMapping("/delete-company/{id}")
    public String deleteCompany(@PathVariable(value = "id") long id) {
        companyService.deleteCompanyById(id);
        return "redirect:/companies";
    }
}
