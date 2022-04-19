package com.bsuir.analytics.service;

import com.bsuir.analytics.model.Case;

import java.util.List;

public interface CaseService {

    List<Case> getAllCases();
    void saveCase(Case analyticCase);
    Case getCaseById(long id);
    void deleteCaseById(long id);
}
