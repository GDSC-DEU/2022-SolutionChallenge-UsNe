package com.gdsc.backend.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    String usrId;

    @Column(nullable = false)
    String userPassword;

    @Column(nullable = false)
    int userPhoneNumber;

    @Column(nullable = false,columnDefinition = "varchar(20)")
    String userName;

    @Column(nullable = true)
    int userBirth;

    @Builder
    public User(String userId,String userPassword,int userPhoneNumber,String userName,int userBirth){
        this.usrId=userId;
        this.userPassword=userPassword;
        this.userPhoneNumber=userPhoneNumber;
        this.userName=userName;
        this.userBirth=userBirth;
    }

}
