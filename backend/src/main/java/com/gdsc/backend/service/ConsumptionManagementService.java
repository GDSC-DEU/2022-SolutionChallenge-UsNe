package com.gdsc.backend.service;

import com.gdsc.backend.domain.Consumption;
import com.gdsc.backend.domain.User;
import com.gdsc.backend.dto.request.ConsumptionRequest;
import com.gdsc.backend.dto.response.ConsumptionResponse;
import com.gdsc.backend.exception.ConsumptionGetFailException;
import com.gdsc.backend.exception.LoginFailException;
import com.gdsc.backend.repository.ConsumptionRepository;
import com.gdsc.backend.repository.UserRepository;
import org.slf4j.Logger;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ConsumptionManagementService {

    private final ConsumptionRepository consumptionRepository;
    private final UserRepository userRepository;

    public ConsumptionManagementService(final ConsumptionRepository consumptionRepository,final UserRepository userRepository){
        this.consumptionRepository=consumptionRepository;
        this.userRepository=userRepository;
    }

    @Transactional
    public Consumption save(final ConsumptionRequest consumptionRequest,final String userId){
        return consumptionRepository.save(Consumption.builder()
                .content(consumptionRequest.getContent())
                .cost(consumptionRequest.getCost())
                .useType(consumptionRequest.getUseType())
                .payType(consumptionRequest.getPayType())
                .dwType(consumptionRequest.getDwType())
                .consumptionDatetime(consumptionRequest.getConsumptionDatetime())
                .user(userRepository.findByUserId(userId))
                .build());
    }

    public Consumption update(Long index, final ConsumptionRequest consumptionRequest){
        Consumption persistConsumption = consumptionRepository.findConsumptionByConsumptionIndex(index);
        persistConsumption.update(consumptionRequest);
        consumptionRepository.save(persistConsumption);
        return persistConsumption;

    }

    public List<Consumption> showConsumptionsByPage(Pageable pageable){
        return consumptionRepository.findAll(pageable).getContent();
    }

    public ConsumptionResponse showByIndex(Long index, final String userId) {
        Consumption consumption;
        try {
            User user = userRepository.findByUserId(userId);
            consumption = consumptionRepository.findConsumptionByConsumptionIndexAndAndUser(index, user);
        } catch (Exception e) {
            throw new ConsumptionGetFailException(e.getMessage());
        }
        return ConsumptionResponse.from(consumption);
    }

    public void delete(Long index){
        consumptionRepository.deleteById(index);
        return;
    }

}
