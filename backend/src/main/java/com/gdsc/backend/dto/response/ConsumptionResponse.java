package com.gdsc.backend.dto.response;

import com.gdsc.backend.domain.Consumption;
import com.gdsc.backend.domain.enums.DwType;
import com.gdsc.backend.domain.enums.PayType;
import com.gdsc.backend.domain.enums.UseType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ConsumptionResponse {
    private String content;
    private int cost;
    private UseType useType;
    private PayType payType;
    private DwType dwType;

    @Builder
    public ConsumptionResponse(String content, int cost, UseType useType, PayType payType, DwType dwType){
        this.content=content;
        this.cost=cost;
        this.useType=useType;
        this.payType=payType;
        this.dwType=dwType;
    }

    public static ConsumptionResponse from(Consumption consumption){
        ConsumptionResponse consumptionResponse=
                ConsumptionResponse.builder()
                        .content(consumption.getContent())
                        .cost(consumption.getCost())
                        .useType(consumption.getUseType())
                        .payType(consumption.getPayType())
                        .dwType(consumption.getDwType())
                        .build();

        return consumptionResponse;
    }
}
