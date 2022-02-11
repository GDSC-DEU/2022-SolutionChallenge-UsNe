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
    private Long index;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private LocalDateTime datetime;

    @ManyToOne
    private User user;

    @Builder
    public ConsumptionGoal(int price, User user){
        this.price = price;
        this.user = user;
    }
}
