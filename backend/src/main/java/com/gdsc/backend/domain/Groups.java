package com.gdsc.backend.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Groups implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "groupListIndex",referencedColumnName = "groupListIndex",nullable = false)
    private GroupList groupList;

    @Id
    @ManyToOne
    @JoinColumn(name = "userId",referencedColumnName = "userId",nullable = false)
    private User user;

    @Builder
    public Groups(GroupList groupList,User user){
        this.groupList=groupList;
        this.user=user;
    }

}
