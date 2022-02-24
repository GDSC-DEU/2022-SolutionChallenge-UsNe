package com.gdsc.backend.service;

import com.gdsc.backend.domain.Consumption;
import com.gdsc.backend.domain.User;
import com.gdsc.backend.dto.request.ConsumptionRequest;
import com.gdsc.backend.dto.response.ConsumptionResponse;
import com.gdsc.backend.exception.ConsumptionDeleteFailException;
import com.gdsc.backend.exception.ConsumptionGetFailException;
import com.gdsc.backend.exception.ConsumptionUpdateFailException;
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

    @Transactional
    public Consumption update(Long index, final ConsumptionRequest consumptionRequest, final String userId){
        try{
            Consumption persistConsumption = consumptionRepository.findConsumptionByConsumptionIndex(index);
            if(persistConsumption.getUser().matchId(userId)){
                persistConsumption.update(consumptionRequest);
                consumptionRepository.save(persistConsumption);
                return persistConsumption;
            }
            else throw new ConsumptionUpdateFailException("사용자가 아님");

        }catch (Exception e){
            throw new ConsumptionUpdateFailException(e.getMessage());
        }
    }

    @Transactional
    public List<Consumption> showConsumptionsByPage(Pageable pageable, final String userId){
        try{
            User user= userRepository.findByUserId(userId);
            return consumptionRepository.findAllByUser(pageable, user);
        }catch (Exception e){
            throw new ConsumptionGetFailException(e.getMessage());
        }
    }

    @Transactional
    public ConsumptionResponse showByIndex(Long index, final String userId) {
        try {
            User user = userRepository.findByUserId(userId);
            Consumption consumption = consumptionRepository.findConsumptionByConsumptionIndexAndAndUser(index,user);
            return ConsumptionResponse.from(consumption);
        } catch (Exception e) {
            throw new ConsumptionGetFailException(e.getMessage());
        }
    }

    @Transactional
    public void delete(Long index, final String userId){
        try{
            Consumption consumption=consumptionRepository.findConsumptionByConsumptionIndex(index);
            if(consumption.getUser().matchId(userId)){
                consumptionRepository.deleteById(index);
                return;
            }
            else throw new ConsumptionDeleteFailException("사용자가 아님");
        }catch (Exception e){
            throw new ConsumptionDeleteFailException(e.getMessage());
        }
    }

}
