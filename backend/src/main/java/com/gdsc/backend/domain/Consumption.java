package com.gdsc.backend.domain;

import com.gdsc.backend.domain.enums.DwType;
import com.gdsc.backend.domain.enums.PayType;
import com.gdsc.backend.domain.enums.UseType;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long consumptionIndex;

    @CreationTimestamp
    private LocalDateTime consumptionDatetime;

    @Column(nullable = true)
    private String content;

    @Column(nullable = false)
    private int cost;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UseType useType;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PayType payType;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DwType dwType;

    /*@ManyToOne
    @JoinColumn(name = "userId",referencedColumnName = "userId",nullable = false)
    private User user;*/

    @Builder
    public Consumption(String content, int consumptionCost, UseType useType, PayType payType, DwType dwType){
        this.content = content;
        this.cost =consumptionCost;
        this.useType=useType;
        this.payType=payType;
        this.dwType=dwType;
    }

    public void update(Consumption consumption){
        this.content =consumption.getContent();
        this.cost = consumption.getCost();
        this.useType=consumption.getUseType();
        this.payType=consumption.getPayType();
        this.dwType=consumption.getDwType();
    }
}
