package com.gdsc.backend.repository;

import com.gdsc.backend.domain.Consumption;
import com.gdsc.backend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumptionRepository extends JpaRepository<Consumption,Long> {
    public Consumption findConsumptionByConsumptionIndex(Long index);

    public Consumption findConsumptionByConsumptionIndexAndAndUser(Long index, User user);
}
