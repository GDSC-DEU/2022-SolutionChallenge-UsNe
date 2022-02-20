package com.gdsc.backend.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Question {
    @Id
    @Schema(description = "문의사항 인덱스", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long questionIndex;

    @Schema(description = "문의사항 제목", nullable = false, example = "그룹생성 문의드립니다.")
    @Column(nullable = false,columnDefinition = "varchar(40)")
    private String title;

    @Schema(description = "문의사항 내용", nullable = true, example = "그룹생성 어떻게 해요..?")
    @Column(nullable = true)
    private String content;

    @Schema(description = "문의사항 작성일", nullable = false, example = "20211203")
    @CreationTimestamp
    private LocalDate questionDateTime;

    @Schema(description = "문의사항 답변", nullable = true, example = "공지사항 내용을 참조하시길 바랍니다.")
    @Column(nullable=true)
    private String answer;

    @ManyToOne
    @JoinColumn(name = "userId",referencedColumnName = "userId",nullable = false)
    private User user;

    @Builder
    public Question(String title, String content, String answer,User user){
        this.title=title;
        this.content=content;
        this.answer=answer;
        this.user=user;
    }
}
