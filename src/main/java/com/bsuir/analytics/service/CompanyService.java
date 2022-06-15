package com.bsuir.analytics.service;

import com.bsuir.analytics.model.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();
   // List<Company> getAllUsersCompanies(long id);
    void saveCompany(Company company);
    Company getCompanyById(long id);
    void deleteCompanyById(long id);
    long countAllCompanies();
}
