package com.gdsc.backend.service;

import com.gdsc.backend.domain.Consumption;
import com.gdsc.backend.repository.ConsumptionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@Service
public class ConsumptionManagementService {
    private ConsumptionRepository consumptionRepository;

    public ConsumptionManagementService(final ConsumptionRepository consumptionRepository){
        this.consumptionRepository=consumptionRepository;
    }

    public Consumption save(final Consumption consumption){
        return consumptionRepository.save(consumption);
    }

    public Consumption update(Long index, final Consumption consumption){
        Consumption persistConsumption = consumptionRepository.findConsumptionByConsumptionIndex(index);
        persistConsumption.update(consumption);
        consumptionRepository.save(persistConsumption);
        return persistConsumption;

    }

    public Page<Consumption> showConsumptionsByPage(Pageable pageable){
        return consumptionRepository.findAll(pageable);
    }

    public Optional<Consumption> showByIndex(Long index){
        return consumptionRepository.findById(index);
    }

    public void delete(Long index){
        consumptionRepository.deleteById(index);
        return;
    }

}
