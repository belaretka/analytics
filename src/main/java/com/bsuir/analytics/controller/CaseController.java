package com.bsuir.analytics.controller;

import com.bsuir.analytics.model.Case;
import com.bsuir.analytics.service.CaseService;
import com.bsuir.analytics.service.CompanyService;
import com.bsuir.analytics.service.SheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CaseController {

    private CaseService caseService;
    private CompanyService companyService;
    private SheetService sheetService;

    @Autowired
    public void setCaseService(CaseService caseService) {
        this.caseService = caseService;
    }

    @Autowired
    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Autowired
    public void setSheetService(SheetService sheetService) {
        this.sheetService = sheetService;
    }

    @GetMapping("/analytics")
    public String viewHomePage(Model model) {
        model.addAttribute("listCases", caseService.getAllCases());
        return "analytics";
    }

    @GetMapping("/add-case")
    public String addCase (Model model) {
        model.addAttribute("listCompanies", companyService.getAllCompanies());
        model.addAttribute("listSheets", sheetService.getAllSheets());
        return "add-case";
    }

    @GetMapping("/delete-case/{id}")
    public String deleteCase (@PathVariable(value = "id") long id) {
        caseService.deleteCaseById(id);
        return "redirect:/analytics";
    }

    //@GetMapping("/print-case/{id}")

    @PostMapping("/save-case")
    public String saveCase(@ModelAttribute(value = "newCase") Case newCase) {
        caseService.saveCase(newCase);
        return "redirect:/analytics";
    }

    @GetMapping("/analyze/{id}")
    public String analyzeSheet (@PathVariable(value = "id") long id) {

        return "analyze";
    }

}
