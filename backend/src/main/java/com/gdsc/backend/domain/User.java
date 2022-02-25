package com.gdsc.backend.domain;

import com.gdsc.backend.dto.request.ConsumptionRequest;
import com.gdsc.backend.dto.request.UserRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Schema(description = "사용자")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
    public static final String INVALID_PASSWORD_MESSAGE = "비밀번호가 틀렸습니다.";

    @Id
    @Schema(description = "사용자의 아이디", nullable = false)
    String userId;

    @Schema(description = "사용자의 비밀번호", nullable = false)
    @Column(nullable = false)
    String userPassword;

    @Schema(description = "사용자의 휴대전화번호", nullable = false)
    @Column(nullable = false)
    String userPhoneNumber;

    @Schema(description = "사용자의 이름", nullable = false)
    @Column(nullable = false,columnDefinition = "varchar(20)")
    String userName;

    @Schema(description = "사용자의 생일", nullable = false)
    @Column(nullable = true)
    String userBirth;

    @Builder
    public User(String userId, String userPassword, String userPhoneNumber, String userName, String userBirth){
        this.userId=userId;
        this.userPassword=userPassword;
        this.userPhoneNumber=userPhoneNumber;
        this.userName=userName;
        this.userBirth=userBirth;
    }

    public void update(UserRequest userRequest) {
        this.userPassword = userRequest.getUserPassword();
        this.userPhoneNumber = userRequest.getUserPhoneNumber();
        this.userName = userRequest.getUserName();
        this.userBirth = userRequest.getUserBirth();
    }

    public void matchPassword(String password) { //비밀번호 확인인
        if (!this.userPassword.equals(password)) {
            throw new IllegalArgumentException(INVALID_PASSWORD_MESSAGE);
        }
    }

    public boolean matchId(Long id) {
        return (id != null) && (id.equals(getUserId()));
    }
}
