package com.bsuir.analytics.service;

import com.bsuir.analytics.model.Company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();
    void saveCompany(Company company);
    Company getCompanyById(long id);
    void deleteCompanyById(long id);
}
