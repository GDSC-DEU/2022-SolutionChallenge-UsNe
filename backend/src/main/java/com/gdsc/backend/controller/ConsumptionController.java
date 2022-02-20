package com.gdsc.backend.controller;

import com.gdsc.backend.domain.Consumption;
import com.gdsc.backend.dto.request.ConsumptionRequest;
import com.gdsc.backend.dto.response.ConsumptionResponse;
import com.gdsc.backend.service.ConsumptionManagementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Tag(name = "consumption", description = "소비 관련 API")
@RestController
@RequestMapping("/api/consumptions")
public class ConsumptionController {

    private ConsumptionManagementService consumptionManagementService;

    public ConsumptionController(final ConsumptionManagementService consumptionManagementService){
        this.consumptionManagementService=consumptionManagementService;
    }

    @Operation(summary = "소비 등록", description = "소비를 입력합니다.", tags = "consumption",
            responses = {
                    @ApiResponse(responseCode = "201", description = "소비 등록 성공",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Consumption.class)))
            }
    )
    @PostMapping
    public ResponseEntity<Consumption> createConsumption(@RequestBody ConsumptionRequest consumptionRequest){
        Consumption creation= consumptionManagementService.save(consumptionRequest);
        return new ResponseEntity<Consumption>(creation, HttpStatus.CREATED);
    }

    @Operation(summary = "전체 소비 조회", description = "전체 소비를 조회합니다.", tags = "consumption",
            responses = {
                    @ApiResponse(responseCode = "200", description = "전체 소비 조회 성공",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Consumption.class)))
            }
    )
    @GetMapping
    public ResponseEntity<List<Consumption>> showConsumptionList(final Pageable pageable){
        List<Consumption> consumptions= consumptionManagementService.showConsumptionsByPage(pageable);
        return new ResponseEntity<List<Consumption>>(consumptions, HttpStatus.OK);
    }

    @Operation(summary = "소비 조회", description = "하나의 소비를 조회합니다.", tags = "consumption",
            responses = {
                    @ApiResponse(responseCode = "200", description = "소비 조회 성공",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ConsumptionResponse.class)))
            }
    )
    @GetMapping("/{index}")
    public ResponseEntity<ConsumptionResponse> showConsumptionByIndex(@PathVariable("index")Long index){
        ConsumptionResponse consumptionResponse= consumptionManagementService.showByIndex(index);
        return new ResponseEntity<ConsumptionResponse>(consumptionResponse, HttpStatus.OK);
    }

    @Operation(summary = "소비 등록", description = "소비를 입력합니다.", tags = "consumption",
            responses = {
                    @ApiResponse(responseCode = "201", description = "소비 등록 성공",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Consumption.class)))
            }
    )
    @PutMapping("/{index}")
    public ResponseEntity<?> updateConsumption(@PathVariable("index")Long index, @RequestBody ConsumptionRequest consumptionRequest){
        Consumption updation= consumptionManagementService.update(index, consumptionRequest);
        return new ResponseEntity<>(updation, HttpStatus.OK);
    }

    @Operation(summary = "소비 등록", description = "소비를 입력합니다.", tags = "consumption",
            responses = {
                    @ApiResponse(responseCode = "201", description = "소비 등록 성공",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Consumption.class)))
            }
    )
    @DeleteMapping("/{index}")
    public ResponseEntity deleteConsumption(@PathVariable("index")Long index){
        consumptionManagementService.delete(index);
        return new ResponseEntity<>("{}",HttpStatus.NO_CONTENT);
    }

}
