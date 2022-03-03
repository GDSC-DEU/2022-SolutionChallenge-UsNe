package com.gdsc.backend.repository;

import com.gdsc.backend.domain.Consumption;
import com.gdsc.backend.domain.User;
import com.gdsc.backend.domain.enums.DwType;
import com.gdsc.backend.domain.enums.PayType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumptionRepository extends JpaRepository<Consumption,Long> {
    public Consumption findConsumptionByConsumptionIndex(Long index);

    public Consumption findConsumptionByConsumptionIndexAndAndUser(Long index, User user);

    public List<Consumption> findAllByUser(Pageable pageable,User user);

}
