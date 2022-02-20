package com.gdsc.backend.service;

import com.gdsc.backend.domain.Consumption;
import com.gdsc.backend.dto.request.ConsumptionRequest;
import com.gdsc.backend.dto.response.ConsumptionResponse;
import com.gdsc.backend.repository.ConsumptionRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumptionManagementService {

    private ConsumptionRepository consumptionRepository;

    public ConsumptionManagementService(final ConsumptionRepository consumptionRepository){
        this.consumptionRepository=consumptionRepository;
    }

    public Consumption save(final ConsumptionRequest consumptionRequest){
        return consumptionRepository.save(Consumption.builder()
                .content(consumptionRequest.getContent())
                .cost(consumptionRequest.getCost())
                .useType(consumptionRequest.getUseType())
                .payType(consumptionRequest.getPayType())
                .dwType(consumptionRequest.getDwType())
                .consumptionDatetime(consumptionRequest.getConsumptionDatetime())
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

    public ConsumptionResponse showByIndex(Long index){
        Consumption consumption=consumptionRepository.findConsumptionByConsumptionIndex(index);
        return ConsumptionResponse.from(consumption);
    }

    public void delete(Long index){
        consumptionRepository.deleteById(index);
        return;
    }

}
