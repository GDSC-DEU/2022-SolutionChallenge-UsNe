package com.gdsc.backend.dto.request;

import com.gdsc.backend.domain.Consumption;
import com.gdsc.backend.domain.enums.UseType;
import com.gdsc.backend.domain.enums.PayType;
import com.gdsc.backend.domain.enums.DwType;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ConsumptionRequest {
    private String content;
    private int cost;
    private DwType dwType;
    private PayType payType;
    private UseType useType;
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
