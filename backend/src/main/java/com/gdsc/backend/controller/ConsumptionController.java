package com.gdsc.backend.controller;

import com.gdsc.backend.domain.Consumption;
import com.gdsc.backend.repository.ConsumptionRepository;
import com.gdsc.backend.service.ConsumptionManagementService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consumptions")
public class ConsumptionController {

    private ConsumptionManagementService consumptionManagementService;

    public ConsumptionController(final ConsumptionManagementService consumptionManagementService){
        this.consumptionManagementService=consumptionManagementService;
    }

    @PostMapping
    public ResponseEntity<?> createConsumption(@RequestBody Consumption consumption){
        Consumption creation= consumptionManagementService.save(consumption);
        return new ResponseEntity<>(creation, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> showConsumptionList(final Pageable pageable){
        Page<Consumption> consumptions= consumptionManagementService.showConsumptionsByPage(pageable);
        return new ResponseEntity<>(consumptions, HttpStatus.OK);
    }

    @GetMapping("/{index}")
    public ResponseEntity<?> showConsumptionByIndex(@PathVariable("index")Long index){
        Optional<Consumption> consumption= consumptionManagementService.showByIndex(index);
        return new ResponseEntity<>(consumption, HttpStatus.OK);
    }

    @PutMapping("/{index}")
    public ResponseEntity<?> updateConsumption(@PathVariable("index")Long index, @RequestBody Consumption consumption){
        Consumption updation= consumptionManagementService.update(index, consumption);
        return new ResponseEntity<>(updation, HttpStatus.OK);
    }

    @DeleteMapping("/{index}")
    public ResponseEntity deleteConsumption(@PathVariable("index")Long index){
        consumptionManagementService.delete(index);
        return new ResponseEntity<>("{}",HttpStatus.OK);
    }
}
