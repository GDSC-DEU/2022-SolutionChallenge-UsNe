package com.gdsc.backend.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ConsumptionGoal {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long consumptionGoalIndex;

    @Column(nullable = false)
    private int price;

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
