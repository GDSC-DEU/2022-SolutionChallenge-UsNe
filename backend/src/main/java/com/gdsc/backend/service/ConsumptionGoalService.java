package com.gdsc.backend.service;

import com.gdsc.backend.domain.ConsumptionGoal;
import com.gdsc.backend.dto.request.ConsumptionGoalRequest;
import com.gdsc.backend.dto.request.ConsumptionRequest;
import com.gdsc.backend.repository.ConsumptionGoalRepository;
import com.gdsc.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ConsumptionGoalService {

    private final ConsumptionGoalRepository consumptionGoalRepository;
    private final UserRepository userRepository;
    public ConsumptionGoalService(final ConsumptionGoalRepository consumptionGoalRepository, final UserRepository userRepository){
        this.consumptionGoalRepository=consumptionGoalRepository;
        this.userRepository=userRepository;
    }

    public ConsumptionGoal saveConsumptionGoal(final ConsumptionGoalRequest consumptionGoalRequest, final String userId){
        return consumptionGoalRepository.save(ConsumptionGoal.builder()
                .education(consumptionGoalRequest.getEducation())
                .traffic(consumptionGoalRequest.getTraffic())
                .beauty(consumptionGoalRequest.getBeauty())
                .culture(consumptionGoalRequest.getCulture())
                .food(consumptionGoalRequest.getFood())
                .life(consumptionGoalRequest.getLife())
                .medicaltreatment(consumptionGoalRequest.getMedicaltreatment())
                .clothes(consumptionGoalRequest.getClothes())
                .ect(consumptionGoalRequest.getEct())
                .user(userRepository.findByUserId(userId))
                .build());
    }
}
