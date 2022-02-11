package com.gdsc.backend.domain;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int index;

    @Column(nullable = false,columnDefinition = "varchar(40)")
    private String title;

    @Column(nullable = true,columnDefinition = "varchar")
    private String content;

    @CreationTimestamp
    private LocalDateTime dateTime;

    @Builder
    public Notice(String title,String content){
        this.title=title;
        this.content=content;
    }
}
