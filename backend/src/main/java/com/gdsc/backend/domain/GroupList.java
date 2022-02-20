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
public class GroupList {
    @Id
    @Schema(description = "그룹 인덱스", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long groupListIndex;

    @Schema(description = "그룹명", nullable = false, example = "쓰지마 돈~!")
    @Column(nullable = false,columnDefinition = "varchar(20)")
    private String name;

    @Schema(description = "그룹 생성 시간", nullable = false)
    @CreationTimestamp
    private LocalDateTime GroupListDateTime;

    @Builder
    public GroupList(String name){
        this.name=name;
    }
}
