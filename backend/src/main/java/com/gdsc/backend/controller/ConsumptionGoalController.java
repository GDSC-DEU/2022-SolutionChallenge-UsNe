package com.gdsc.backend.controller;

import com.gdsc.backend.domain.Consumption;
import com.gdsc.backend.domain.ConsumptionGoal;
import com.gdsc.backend.dto.request.ConsumptionGoalRequest;
import com.gdsc.backend.dto.request.ConsumptionRequest;
import com.gdsc.backend.service.ConsumptionGoalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@Tag(name = "consumptionGoal", description = "목표 소비 설정 관련 API")
@RestController
@RequestMapping("/api/consumptionGoals")
public class ConsumptionGoalController {

    private final ConsumptionGoalService consumptionGoalService;

    public ConsumptionGoalController(final ConsumptionGoalService consumptionGoalService){
        this.consumptionGoalService=consumptionGoalService;
    }

    @Operation(summary = "목표 소비 설정", description = "목표 소비를 입력합니다.", tags = "consumptionGoal",
            responses = {
                    @ApiResponse(responseCode = "201", description = "목표 소비 등록 성공",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ConsumptionGoal.class)))
            }
    )
    @PostMapping
    public ResponseEntity<ConsumptionGoal> setConsumtionGoal(@RequestBody ConsumptionGoalRequest consumptionGoalRequest, HttpSession httpSession){
        ConsumptionGoal consumptionGoal= consumptionGoalService.saveConsumptionGoal(consumptionGoalRequest, httpSession.getAttribute("user_id").toString());
        return new ResponseEntity<ConsumptionGoal>(consumptionGoal,HttpStatus.CREATED);
    }

}
