package com.bsuir.analytics.repository;

import com.bsuir.analytics.model.Ratio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatioRepository extends JpaRepository<Ratio, Long> {
}
