package com.gdsc.backend.dto.response;

import com.gdsc.backend.domain.Consumption;
import com.gdsc.backend.domain.enums.UseType;
import com.gdsc.backend.domain.enums.PayType;
import com.gdsc.backend.domain.enums.DwType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ConsumptionResponse {
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
    public ConsumptionResponse(String content, int cost, DwType dwType, PayType payType, UseType useType,int consumptionDatetime){
        this.content=content;
        this.cost=cost;
        this.dwType = dwType;
        this.payType=payType;
        this.useType = useType;
        this.consumptionDatetime=consumptionDatetime;
    }

    public static ConsumptionResponse from(Consumption consumption){
        ConsumptionResponse consumptionResponse=
                ConsumptionResponse.builder()
                        .content(consumption.getContent())
                        .cost(consumption.getCost())
                        .useType(consumption.getUseType())
                        .payType(consumption.getPayType())
                        .dwType(consumption.getDwType())
                        .consumptionDatetime(consumption.getConsumptionDatetime())
                        .build();

        return consumptionResponse;
    }
}
