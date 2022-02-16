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
public class GroupList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long groupListIndex;

    @Column(nullable = false,columnDefinition = "varchar(20)")
    private String name;

    @CreationTimestamp
    private LocalDateTime GroupListDateTime;

    @Builder
    public GroupList(String name){
        this.name=name;
    }
}
