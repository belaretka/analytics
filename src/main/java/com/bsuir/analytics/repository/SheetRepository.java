package com.bsuir.analytics.repository;

import com.bsuir.analytics.model.Case;
import com.bsuir.analytics.model.Sheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SheetRepository extends JpaRepository<Sheet, Long> {

    Sheet findById(long id);
}
