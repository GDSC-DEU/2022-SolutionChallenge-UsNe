package com.gdsc.backend.repository;

import com.gdsc.backend.domain.ConsumptionGoal;
import com.gdsc.backend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumptionGoalRepository extends JpaRepository<ConsumptionGoal, Long> {
}
