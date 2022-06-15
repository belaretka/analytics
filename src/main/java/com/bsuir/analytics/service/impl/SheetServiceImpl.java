package com.bsuir.analytics.service.impl;

import com.bsuir.analytics.model.Sheet;
import com.bsuir.analytics.repository.SheetRepository;
import com.bsuir.analytics.service.SheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SheetServiceImpl implements SheetService {

    private SheetRepository sheetRepository;

    @Autowired
    public void setSheetRepository(SheetRepository sheetRepository) {
        this.sheetRepository = sheetRepository;
    }

    @Override
    public List<Sheet> getAllSheets() {
        return sheetRepository.findAll();
    }

    @Override
    public void saveSheet(Sheet sheet) {
        sheetRepository.save(sheet);
    }

    @Override
    public Sheet getSheetById(long id) {
        Optional<Sheet> optional = Optional.ofNullable(sheetRepository.findById(id));
        Sheet s = null;
        if(optional.isPresent())
            s = optional.get();
        else throw new RuntimeException("Not found");
        return s;
    }

    @Override
    public void deleteSheetById(long id) {
        sheetRepository.deleteById(id);
    }


}
