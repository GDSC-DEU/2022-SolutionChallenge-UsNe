package com.gdsc.backend.controller;

import com.gdsc.backend.domain.ConsumptionGoal;
import com.gdsc.backend.dto.request.ConsumptionGoalRequest;
import com.gdsc.backend.dto.response.ConsumptionGoalResponse;
import com.gdsc.backend.repository.ConsumptionGoalRepository;
import com.gdsc.backend.service.ConsumptionGoalService;
import com.gdsc.backend.service.ConsumptionManagementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Tag(name = "consumptionGoal", description = "목표 소비 설정 관련 API")
@RestController
@RequestMapping("/api/consumptionGoals")
public class ConsumptionGoalController {

    private final ConsumptionGoalService consumptionGoalService;
    private final ConsumptionManagementService consumptionManagementService;
    public ConsumptionGoalController(final ConsumptionGoalService consumptionGoalService,final ConsumptionManagementService consumptionManagementService){
        this.consumptionGoalService=consumptionGoalService;
        this.consumptionManagementService=consumptionManagementService;
    }

    @Operation(summary = "목표 소비 설정", description = "목표 소비를 입력합니다.", tags = "consumptionGoal",
            responses = {
                    @ApiResponse(responseCode = "201", description = "목표 소비 등록 성공",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ConsumptionGoal.class)))
            }
    )
    @PostMapping
    public ResponseEntity<ConsumptionGoal> setConsumptionGoal(@RequestBody ConsumptionGoalRequest consumptionGoalRequest, HttpSession httpSession){
        ConsumptionGoal consumptionGoal= consumptionGoalService.saveConsumptionGoal(consumptionGoalRequest, httpSession.getAttribute("user_id").toString());
        return new ResponseEntity<ConsumptionGoal>(consumptionGoal,HttpStatus.CREATED);
    }

    @Operation(summary = "목표 소비 조회", description = "목표 소비를 조회합니다.", tags = "consumptionGoal",
            responses = {
                    @ApiResponse(responseCode = "200", description = "목표 조회 등록 성공",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ConsumptionGoal.class)))
            }
    )
    @GetMapping
    public ResponseEntity<ConsumptionGoal> showConsumptionGoal(HttpSession httpSession){
        ConsumptionGoal thisConsumptionGoal=consumptionGoalService.showConsumptionGoal(httpSession.getAttribute("user_id").toString());
        return new ResponseEntity<ConsumptionGoal>(thisConsumptionGoal,HttpStatus.OK);
    }

    @Operation(summary = "목표 소비 업데이트", description = "목표 소비를 업데이트합니다.", tags = "consumptionGoal",
            responses = {
                    @ApiResponse(responseCode = "200", description = "목표 조회 업데이트 성공",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ConsumptionGoal.class)))
            }
    )
    @PutMapping
    public ResponseEntity<ConsumptionGoal> updateConsumptionGoal(@RequestBody ConsumptionGoalRequest consumptionGoalRequest, HttpSession httpSession){
        ConsumptionGoal updatedConsumptionGoal=consumptionGoalService.updateConsumptionGoal(consumptionGoalRequest, httpSession.getAttribute("user_id").toString());
        return new ResponseEntity<ConsumptionGoal>(updatedConsumptionGoal, HttpStatus.OK);
    }

    @GetMapping("/calc")
    public ResponseEntity<ConsumptionGoalResponse> calcConsumption(HttpSession httpSession){
        ConsumptionGoalResponse consumptionGoal = consumptionManagementService.calcThisMonthConsumption(httpSession.getAttribute("user_id").toString());
        return new ResponseEntity<ConsumptionGoalResponse>(consumptionGoal,HttpStatus.OK);
    }
}
