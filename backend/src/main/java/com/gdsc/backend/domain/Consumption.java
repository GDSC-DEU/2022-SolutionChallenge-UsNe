package com.gdsc.backend.domain;

import com.gdsc.backend.domain.enums.DwType;
import com.gdsc.backend.domain.enums.PayType;
import com.gdsc.backend.domain.enums.UseType;
import lombok.Builder;
import org.hibernate.usertype.UserType;

import javax.persistence.*;
import java.time.LocalDateTime;

public class Consumption {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int index;

    @Column(nullable = false)
    private LocalDateTime datetime;

    @Column(nullable = true, columnDefinition = "varchar")
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

    @ManyToOne
    private User user;

    @Builder
    public Consumption(LocalDateTime datetime, String content, int cost, UseType useType, PayType payType, DwType dwType, User user){
        this.datetime=datetime;
        this.content=content;
        this.cost=cost;
        this.useType=useType;
        this.payType=payType;
        this.dwType=dwType;
        this.user=user;
    }
}
