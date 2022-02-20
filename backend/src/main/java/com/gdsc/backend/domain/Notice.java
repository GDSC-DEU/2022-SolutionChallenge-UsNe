package com.gdsc.backend.domain;

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
public class Notice {
    @Id
    @Schema(description = "공지사항 인덱스", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long noticeIndex;

    @Schema(description = "공지사항 제목", nullable = false, example = "그룹생성 방법 설명")
    @Column(nullable = false,columnDefinition = "varchar(40)")
    private String title;

    @Schema(description = "공지사항 내용", nullable = true, example = "그룹 생성 방법은 ....")
    @Column(nullable = true)
    private String content;

    @Schema(description = "공지사항 작성일", nullable = false, example = "20220123")
    @CreationTimestamp
    private LocalDateTime noticeDateTime;

    @Builder
    public Notice(String title,String content){
        this.title=title;
        this.content=content;
    }
}
