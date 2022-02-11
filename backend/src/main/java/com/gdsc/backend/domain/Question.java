package com.gdsc.backend.domain;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int index;

    @Column(nullable = false,columnDefinition = "varchar(40)")
    private String title;

    @Column(nullable = true)
    private String content;

    @CreationTimestamp
    private LocalDate dateTime;

    @Column(nullable=true)
    private String answer;

    @ManyToOne
    private User user;

    @Builder
    public Question(String title, String content, String answer,User user){
        this.title=title;
        this.content=content;
        this.answer=answer;
        this.user=user;
    }
}
