package com.bsuir.analytics.repository;

import com.bsuir.analytics.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    List<Company> findCompaniesById(long id);
    Company findCompanyById(long id);
    Company findCompanyByName(String name);
}
