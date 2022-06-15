package com.bsuir.analytics.service;

import com.bsuir.analytics.model.Sheet;

import java.util.List;

public interface SheetService {
    List<Sheet> getAllSheets();
    void saveSheet (Sheet sheet);
    Sheet getSheetById(long id);
    void deleteSheetById(long id);
    //List<Sheet> getAllCompanySheet(long id_company);
}
