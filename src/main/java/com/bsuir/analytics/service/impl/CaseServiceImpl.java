package com.bsuir.analytics.service.impl;

import com.bsuir.analytics.model.Case;
import com.bsuir.analytics.repository.CaseRepository;
import com.bsuir.analytics.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaseServiceImpl implements CaseService {

    private CaseRepository caseRepository;

    @Autowired
    public void setCaseRepository(CaseRepository caseRepository) {
        this.caseRepository = caseRepository;
    }

    @Override
    public List<Case> getAllCases() {
        return caseRepository.findAll();
    }

    @Override
    public void saveCase(Case analyticCase) {
        caseRepository.save(analyticCase);
    }

    @Override
    public Case getCaseById(long id) {
        Optional<Case> optional = Optional.ofNullable(caseRepository.findById(id));
        Case c = null;
        if(optional.isPresent())
            c = optional.get();
        else throw new RuntimeException("Case not found");
        return c;
    }

    @Override
    public void deleteCaseById(long id) {
        caseRepository.deleteById(id);
    }
}
