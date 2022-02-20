package com.gdsc.backend.repository;

import com.gdsc.backend.domain.Consumption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumptionRepository extends JpaRepository<Consumption,Long> {
    public Consumption findConsumptionByConsumptionIndex(Long index);
}
