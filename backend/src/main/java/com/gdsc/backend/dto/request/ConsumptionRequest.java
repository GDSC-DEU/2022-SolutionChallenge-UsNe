package com.gdsc.backend.dto.request;

import com.gdsc.backend.domain.Consumption;
import com.gdsc.backend.domain.enums.UseType;
import com.gdsc.backend.domain.enums.PayType;
import com.gdsc.backend.domain.enums.DwType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ConsumptionRequest {
    @Schema(description = "소비 내용", nullable = true, example = "Content")
    private String content;

    @Schema(description = "소비 금액", nullable = true, example = "1000")
    private int cost;

    @Schema(description = "입출내용", nullable = false, allowableValues = {"DEPOSIT", "WITHDRAW"}, example = "DEPOSIT")
    private DwType dwType;

    @Schema(description = "지불수단", nullable = false, allowableValues = {"ACCOUNTTRANSFER", "CARD","GIRTCARD","CASH"}, example = "CARD")
    private PayType payType;

    @Schema(description = "사용수단", nullable = false, allowableValues = {"EDUCATION", "TRAFFIC","BEAUTY","CULTURE","FOOD","LIFE","MEDICALTREATMENT","CLOTHES","ETC"}, example = "FOOD")
    private UseType useType;

    @Schema(description = "소비 날짜", nullable = false,example = "20220530")
    private int consumptionDatetime;

    @Builder
    public ConsumptionRequest(String content, int cost, DwType dwType, PayType payType, UseType useType,int consumptionDatetime){
        this.content=content;
        this.cost=cost;
        this.dwType = dwType;
        this.payType=payType;
        this.useType = useType;
        this.consumptionDatetime=consumptionDatetime;
    }

    public Consumption toEntity(){
        return Consumption.builder()
                .content(content)
                .cost(cost)
                .useType(useType)
                .payType(payType)
                .dwType(dwType)
                .consumptionDatetime(consumptionDatetime)
                .build();
    }
}
