package com.gdsc.backend.domain;

import lombok.*;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ConsumptionGoal {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long index;

    @Column
    private int price;

    @Column
    private LocalDateTime datetime;

    @ManyToOne
    private User user;

    @Builder
    public ConsumptionGoal(int price, User user){
        this.price = price;
        this.user = user;
    }
}
