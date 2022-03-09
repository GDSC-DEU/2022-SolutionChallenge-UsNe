package com.gdsc.backend.domain;

import com.gdsc.backend.domain.enums.UseType;
import com.gdsc.backend.dto.request.ConsumptionGoalRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

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

    @Schema(description = "교육 목표 소비액", nullable = false, example = "500000")
    @Column(nullable = false)
    private int education;

    @Schema(description = "교통 목표 소비액", nullable = false, example = "500000")
    @Column(nullable = false)
    private int traffic;

    @Schema(description = "미용 목표 소비액", nullable = false, example = "500000")
    @Column(nullable = false)
    private int beauty;

    @Schema(description = "문화 목표 소비액", nullable = false, example = "500000")
    @Column(nullable = false)
    private int culture;

    @Schema(description = "음식 목표 소비액", nullable = false, example = "500000")
    @Column(nullable = false)
    private int food;

    @Schema(description = "생활 목표 소비액", nullable = false, example = "500000")
    @Column(nullable = false)
    private int life;

    @Schema(description = "의료 목표 소비액", nullable = false, example = "500000")
    @Column(nullable = false)
    private int medicaltreatment;

    @Schema(description = "옷 목표 소비액", nullable = false, example = "500000")
    @Column(nullable = false)
    private int clothes;

    @Schema(description = "기타 목표 소비액", nullable = false, example = "500000")
    @Column(nullable = false)
    private int ect;

    @Schema(description = "소비 목표 작성일", nullable = false, example = "20220201")
    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime consumptionGoalDatetime;

    @ManyToOne
    @JoinColumn(name = "userId",referencedColumnName = "userId",nullable = false)
    private User user;

    @Builder
    public ConsumptionGoal(int education, int traffic, int beauty, int culture,
                           int food, int life, int medicaltreatment, int clothes, int ect,User user){
        this.education=education;
        this.traffic=traffic;
        this.beauty=beauty;
        this.culture=culture;
        this.food=food;
        this.life=life;
        this.medicaltreatment=medicaltreatment;
        this.clothes=clothes;
        this.ect=ect;
        this.user=user;
    }

    public void update(ConsumptionGoalRequest consumptionGoalRequest){
        this.education=consumptionGoalRequest.getEducation();
        this.traffic=consumptionGoalRequest.getTraffic();
        this.beauty=consumptionGoalRequest.getBeauty();
        this.culture=consumptionGoalRequest.getCulture();
        this.food=consumptionGoalRequest.getFood();
        this.life=consumptionGoalRequest.getLife();
        this.medicaltreatment=consumptionGoalRequest.getMedicaltreatment();
        this.clothes=consumptionGoalRequest.getClothes();
        this.ect=consumptionGoalRequest.getEct();
    }
}
