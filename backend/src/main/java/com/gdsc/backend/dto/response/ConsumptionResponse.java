package com.gdsc.backend.dto.response;

import com.gdsc.backend.domain.Consumption;
import com.gdsc.backend.domain.enums.UseType;
import com.gdsc.backend.domain.enums.PayType;
import com.gdsc.backend.domain.enums.DwType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ConsumptionResponse {
    private String content;
    private int cost;
    private DwType dwType;
    private PayType payType;
    private UseType useType;
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
