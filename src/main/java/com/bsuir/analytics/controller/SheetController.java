package com.bsuir.analytics.controller;

import com.bsuir.analytics.model.Sheet;
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
public class SheetController {

    private SheetService sheetService;
    private CompanyService companyService;

    @Autowired
    public void setSheetService(SheetService sheetService) {
        this.sheetService = sheetService;
    }

    @Autowired
    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/sheets")
    public String viewShortTable(Model model) {
        model.addAttribute("listSheets", sheetService.getAllSheets());
        return "sheets";
    }

    @GetMapping("/add-sheet")
    public String addSheet (Model model) {
        Sheet sheet = new Sheet();
        model.addAttribute("sheet", sheet);
        model.addAttribute("listCompanies", companyService.getAllCompanies());
        return "add-sheet";
    }

    @PostMapping("/save-sheet")
    public String saveSheet(@ModelAttribute("sheet") Sheet sheet) {
        sheetService.saveSheet(sheet);
        return "redirect:/sheets";
    }

    @GetMapping("/update-sheet/{id}")
    public String updateSheetForm(@PathVariable(value = "id") long id, Model model) {
        Sheet sheet = sheetService.getSheetById(id);
        model.addAttribute("sheet", sheet);
        model.addAttribute("listCompanies", companyService.getAllCompanies());
        return "update-sheet";
    }
    @PostMapping("/update-sheet/{id}")
    public String updateSheet (@PathVariable(value = "id") long id, Sheet sheet) {
        sheetService.saveSheet(sheet);
        return "redirect:/sheets";
    }

    @GetMapping("/delete-sheet/{id}")
    public String deleteSheet (@PathVariable(value = "id") long id) {
        sheetService.deleteSheetById(id);
        return "redirect:/sheets";
    }

    @GetMapping("/show-full-sheet/{id}")
    public String showFullSheet(@PathVariable(value = "id") long id, Model model){
        model.addAttribute("sheet", sheetService.getSheetById(id));
        return "show-full-sheet";
    }

    @GetMapping("/print-sheet/{id}")
    public String printSheet(@PathVariable (value="id") long id) {
        return "redirect:/sheets";
    }

}
