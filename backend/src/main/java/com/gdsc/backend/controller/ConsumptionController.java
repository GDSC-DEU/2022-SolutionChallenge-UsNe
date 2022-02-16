package com.gdsc.backend.controller;

import com.gdsc.backend.domain.Consumption;
import com.gdsc.backend.service.ConsumptionManagementService;
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
    public ResponseEntity<Consumption> createConsumption(@RequestBody Consumption consumption){
        Consumption creation=consumptionManagementService.save(consumption);
        return ResponseEntity.ok().body(consumption);
    }

    @GetMapping
    public List<Consumption> showConsumptionList(){
        return consumptionManagementService.showAll();
    }

    @GetMapping("/{index}")
    public Optional<Consumption> showConsumptionByIndex(@PathVariable("index")Long index){
        return consumptionManagementService.showByIndex(index);
    }

    @PutMapping("/{index}")
    public ResponseEntity<?> updateConsumption(@PathVariable("index")Long index, @RequestBody Consumption consumption){
        Consumption updation= consumptionManagementService.update(index, consumption);
        return ResponseEntity.ok().body(updation);
    }

    @DeleteMapping("/{index}")
    public void deleteConsumption(@PathVariable("index")Long index){
        consumptionManagementService.delete(index);
    }
}
