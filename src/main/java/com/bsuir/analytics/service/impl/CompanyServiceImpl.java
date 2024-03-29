package com.bsuir.analytics.service.impl;

import com.bsuir.analytics.model.Company;
import com.bsuir.analytics.repository.CompanyRepository;
import com.bsuir.analytics.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    @Autowired
    public void setCompanyRepository(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public long countAllCompanies() {
        return companyRepository.count();
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public void saveCompany(Company company) {
        this.companyRepository.save(company);
    }

    @Override
    public Company getCompanyById(long id) {
        Optional<Company> optional = companyRepository.findById(id);
        Company company = null;
        if(optional.isPresent())
            company=optional.get();
        else throw new RuntimeException("Company not found");
        return company;
    }

    @Override
    public void deleteCompanyById(long id) {
        this.companyRepository.deleteById(id);
    }
}
