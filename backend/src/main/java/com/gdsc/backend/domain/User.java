package com.gdsc.backend.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Schema(description = "사용자")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @Schema(description = "사용자의 아이디", nullable = false)
    String userId;

    @Schema(description = "사용자의 비밀번호", nullable = false)
    @Column(nullable = false)
    String userPassword;

    @Schema(description = "사용자의 휴대전화번호", nullable = false)
    @Column(nullable = false)
    int userPhoneNumber;

    @Schema(description = "사용자의 이름", nullable = false)
    @Column(nullable = false,columnDefinition = "varchar(20)")
    String userName;

    @Schema(description = "사용자의 생일", nullable = false)
    @Column(nullable = true)
    int userBirth;

    @Builder
    public User(String userId,String userPassword,int userPhoneNumber,String userName,int userBirth){
        this.userId=userId;
        this.userPassword=userPassword;
        this.userPhoneNumber=userPhoneNumber;
        this.userName=userName;
        this.userBirth=userBirth;
    }

}
