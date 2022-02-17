package com.gdsc.backend.dto.request;

import com.gdsc.backend.domain.Consumption;
import com.gdsc.backend.domain.enums.DwType;
import com.gdsc.backend.domain.enums.PayType;
import com.gdsc.backend.domain.enums.UseType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class ConsumptionRequest {
    private String content;
    private int cost;
    private UseType useType;
    private PayType payType;
    private DwType dwType;

    @Builder
    public ConsumptionRequest(String content, int cost, UseType useType, PayType payType, DwType dwType){
        this.content=content;
        this.cost=cost;
        this.useType=useType;
        this.payType=payType;
        this.dwType=dwType;
    }

    public Consumption toEntity(){
        return Consumption.builder()
                .content(content)
                .cost(cost)
                .useType(useType)
                .payType(payType)
                .dwType(dwType)
                .build();
    }
}
