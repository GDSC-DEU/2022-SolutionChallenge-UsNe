package com.gdsc.backend.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ConsumptionGoal {
    @Id
    @Schema(description = "소비 목표 인덱스", nullable = false)
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long consumptionGoalIndex;

    @Schema(description = "소비 목표 금액", nullable = false, example = "500000")
    @Column(nullable = false)
    private int price;

    @Schema(description = "소비 목표 작성일", nullable = false, example = "20220201")
    @Column(nullable = false)
    private LocalDateTime consumptionGoalDatetime;

    @ManyToOne
    @JoinColumn(name = "userId",referencedColumnName = "userId",nullable = false)
    private User user;

    @Builder
    public ConsumptionGoal(int price){
        this.price = price;
    }
}
