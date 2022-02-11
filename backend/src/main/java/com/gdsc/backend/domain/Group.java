package com.gdsc.backend.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Group {

    @Id
    @ManyToOne
    private GroupList groupList;

    @Id
    @ManyToOne
    private User user;

    @Builder
    public Group(GroupList groupList,User user){
        this.groupList=groupList;
        this.user=user;
    }
}
