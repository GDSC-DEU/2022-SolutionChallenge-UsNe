package com.gdsc.backend.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@AllArgsConstructor
public class ConsumptionGoalResponse {
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

    public ConsumptionGoalResponse(){
        this.education=0;
        this.traffic=0;
        this.beauty=0;
        this.culture=0;
        this.food=0;
        this.life=0;
        this.medicaltreatment=0;
        this.clothes=0;
        this.ect=0;
    }
}
