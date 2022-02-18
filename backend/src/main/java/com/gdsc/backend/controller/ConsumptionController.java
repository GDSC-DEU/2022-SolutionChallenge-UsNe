package com.gdsc.backend.controller;

import com.gdsc.backend.domain.Consumption;
import com.gdsc.backend.dto.request.ConsumptionRequest;
import com.gdsc.backend.dto.response.ConsumptionResponse;
import com.gdsc.backend.service.ConsumptionManagementService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/consumptions")
public class ConsumptionController {

    private ConsumptionManagementService consumptionManagementService;

    public ConsumptionController(final ConsumptionManagementService consumptionManagementService){
        this.consumptionManagementService=consumptionManagementService;
    }

    @PostMapping
    public ResponseEntity<?> createConsumption(@RequestBody ConsumptionRequest consumptionRequest){
        Consumption creation= consumptionManagementService.save(consumptionRequest);
        return new ResponseEntity<>(creation, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> showConsumptionList(final Pageable pageable){
        List<Consumption> consumptions= consumptionManagementService.showConsumptionsByPage(pageable);
        return new ResponseEntity<>(consumptions, HttpStatus.OK);
    }

    @GetMapping("/{index}")
    public ResponseEntity<?> showConsumptionByIndex(@PathVariable("index")Long index){
        ConsumptionResponse consumptionResponse= consumptionManagementService.showByIndex(index);
        return new ResponseEntity<>(consumptionResponse, HttpStatus.OK);
    }

    @PutMapping("/{index}")
    public ResponseEntity<?> updateConsumption(@PathVariable("index")Long index, @RequestBody ConsumptionRequest consumptionRequest){
        Consumption updation= consumptionManagementService.update(index, consumptionRequest);
        return new ResponseEntity<>(updation, HttpStatus.OK);
    }

    @DeleteMapping("/{index}")
    public ResponseEntity deleteConsumption(@PathVariable("index")Long index){
        consumptionManagementService.delete(index);
        return new ResponseEntity<>("{}",HttpStatus.NO_CONTENT);
    }
}
