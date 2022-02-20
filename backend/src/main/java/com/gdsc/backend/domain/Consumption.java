package com.gdsc.backend.domain;

import com.gdsc.backend.domain.enums.UseType;
import com.gdsc.backend.domain.enums.PayType;
import com.gdsc.backend.domain.enums.DwType;
import com.gdsc.backend.dto.request.ConsumptionRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Consumption {
    @Id
    @Schema(description = "소비 인덱스", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long consumptionIndex;

    @Schema(description = "소비 날짜", nullable = false,example = "20220530")
    @Column(nullable = false)
    private int consumptionDatetime;

    @Schema(description = "소비 내용", nullable = true, example = "Content")
    @Column(nullable = true,columnDefinition = "TEXT")
    private String content;

    @Schema(description = "소비 금액", nullable = true, example = "1000")
    @Column(nullable = false)
    private int cost;

    @Schema(description = "입출내용", nullable = false, allowableValues = {"DEPOSIT", "WITHDRAW"}, example = "DEPOSIT")
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DwType dwType;

    @Schema(description = "지불수단", nullable = false, allowableValues = {"ACCOUNTTRANSFER", "CARD","GIRTCARD","CASH"}, example = "CARD")
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PayType payType;

    @Schema(description = "사용수단", nullable = false, allowableValues = {"EDUCATION", "TRAFFIC","BEAUTY","CULTURE","FOOD","LIFE","MEDICALTREATMENT","CLOTHES","ETC"}, example = "FOOD")
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UseType useType;

    /*@ManyToOne
    @JoinColumn(name = "userId",referencedColumnName = "userId",nullable = false)
    private User user;*/

    @Builder
    public Consumption(String content, int cost, DwType dwType, PayType payType, UseType useType,int consumptionDatetime){
        this.content = content;
        this.cost =cost;
        this.dwType = dwType;
        this.payType=payType;
        this.useType = useType;
        this.consumptionDatetime=consumptionDatetime;
    }

    public void update(ConsumptionRequest consumptionRequest){
        this.content =consumptionRequest.getContent();
        this.cost = consumptionRequest.getCost();
        this.dwType =consumptionRequest.getDwType();
        this.payType=consumptionRequest.getPayType();
        this.useType =consumptionRequest.getUseType();
        this.consumptionDatetime=consumptionRequest.getConsumptionDatetime();
    }
}
