package com.bsuir.analytics.repository;

import com.bsuir.analytics.model.Case;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaseRepository extends JpaRepository<Case, Long> {

    Case findById(long id);
    List<Case> findAllByCompany_Name(String companyName);
}

