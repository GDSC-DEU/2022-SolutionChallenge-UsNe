package com.gdsc.backend.controller;

import com.gdsc.backend.domain.Consumption;
import com.gdsc.backend.domain.enums.DwType;
import com.gdsc.backend.domain.enums.PayType;
import com.gdsc.backend.domain.enums.UseType;
import com.gdsc.backend.dto.request.ConsumptionRequest;
import com.gdsc.backend.dto.response.ConsumptionResponse;
import com.gdsc.backend.service.ConsumptionManagementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Tag(name = "consumption", description = "소비 관련 API")
@RestController
@RequestMapping("/api/consumptions")
public class ConsumptionController {

    private final ConsumptionManagementService consumptionManagementService;

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
    public ResponseEntity<Consumption> createConsumption(@RequestBody ConsumptionRequest consumptionRequest, HttpSession httpSession){
        Consumption creation= consumptionManagementService.save(consumptionRequest, httpSession.getAttribute("user_id").toString());
        return new ResponseEntity<Consumption>(creation, HttpStatus.CREATED);
    }

    @Operation(summary = "전체 소비 조회", description = "전체 소비를 조회합니다.", tags = "consumption",
            responses = {
                    @ApiResponse(responseCode = "200", description = "전체 소비 조회 성공",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Consumption.class)))
            }
    )
    @GetMapping
    public ResponseEntity<List<Consumption>> showConsumptionList(final Pageable pageable,HttpSession httpSession){
        List<Consumption> consumptions= consumptionManagementService.showConsumptionsByPage(pageable, httpSession.getAttribute("user_id").toString());
        return new ResponseEntity<List<Consumption>>(consumptions, HttpStatus.OK);
    }

    @Operation(summary = "소비 조회", description = "하나의 소비를 조회합니다.", tags = "consumption",
            responses = {
                    @ApiResponse(responseCode = "200", description = "소비 조회 성공",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ConsumptionResponse.class)))
            }
    )
    @GetMapping("/{index}")
    public ResponseEntity<ConsumptionResponse> showConsumptionByIndex(@Parameter(name = "index", in = ParameterIn.PATH, description = "조회할 소비의 인덱스")
                                                                          @PathVariable("index")Long index, HttpSession httpSession){
        ConsumptionResponse consumptionResponse= consumptionManagementService.showByIndex(index, httpSession.getAttribute("user_id").toString());
        return new ResponseEntity<ConsumptionResponse>(consumptionResponse, HttpStatus.OK);
    }

    @Operation(summary = "소비 수정", description = "소비를 수정합니다.", tags = "consumption",
            responses = {
                    @ApiResponse(responseCode = "200", description = "소비 수정 성공",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Consumption.class)))
            }
    )
    @PutMapping("/{index}")
    public ResponseEntity<?> updateConsumption(@Parameter(name = "index", in = ParameterIn.PATH, description = "수정할 소비의 인덱스")
                                                   @PathVariable("index")Long index, @RequestBody ConsumptionRequest consumptionRequest,
                                               HttpSession httpSession){
        Consumption updation= consumptionManagementService.update(index, consumptionRequest, httpSession.getAttribute("user_id").toString());
        return new ResponseEntity<>(updation, HttpStatus.OK);
    }

    @Operation(summary = "소비 삭제", description = "소비를 삭제합니다.", tags = "consumption",
            responses = {
                    @ApiResponse(responseCode = "200", description = "소비 삭제 성공",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
            }
    )
    @DeleteMapping("/{index}")
    public ResponseEntity deleteConsumption(@Parameter(name = "index", in = ParameterIn.PATH, description = "삭제할 소비의 인덱스")
                                                @PathVariable("index")Long index,HttpSession httpSession){
        consumptionManagementService.delete(index, httpSession.getAttribute("user_id").toString());
        return new ResponseEntity<>("{}", HttpStatus.NO_CONTENT);
    }


    @GetMapping("/search")
    public ResponseEntity<List<ConsumptionResponse>> searchConsumptionByTag(@RequestParam(value="useType", required = false) UseType useType,
                                                                            @RequestParam(value = "dwType", required = false) DwType dwType,
                                                                            @RequestParam(value="payType", required = false) PayType payType,
                                                                            HttpSession httpSession){
        List<ConsumptionResponse> consumptions = consumptionManagementService.search(useType,dwType,payType,httpSession.getAttribute("user_id").toString());
        return new ResponseEntity<List<ConsumptionResponse>>(consumptions,HttpStatus.OK);
    }

}
