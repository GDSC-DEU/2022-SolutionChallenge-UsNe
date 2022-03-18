package com.gdsc.backend.domain;

import com.gdsc.backend.dto.request.ConsumptionRequest;
import com.gdsc.backend.dto.request.UserRequest;
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
    public static final String INVALID_PASSWORD_MESSAGE = "비밀번호가 틀렸습니다.";

    @Id
    @Schema(description = "사용자 아이디", nullable = false, example = "ujeong1009")
    String userId;

    @Schema(description = "사용자 비밀번호", nullable = false, example = "asdf1234")
    @Column(nullable = false)
    String userPassword;

    @Schema(description = "사용자 휴대전화번호", nullable = false, example = "010-2546-7788")
    @Column(nullable = false)
    String userPhoneNumber;

    @Schema(description = "사용자 이름", nullable = false, example = "남지정")
    @Column(nullable = false,columnDefinition = "varchar(20)")
    String userName;

    @Schema(description = "사용자 생일", nullable = false, example = "2000.12.24")
    @Column(nullable = true)
    String userBirth;

    @Schema(description = "활동 가능 상태", nullable = false, example = "True")
    @Column(nullable = false)
    Boolean status;

    @Builder
    public User(String userId, String userPassword, String userPhoneNumber, String userName, String userBirth, Boolean status){
        this.userId=userId;
        this.userPassword=userPassword;
        this.userPhoneNumber=userPhoneNumber;
        this.userName=userName;
        this.userBirth=userBirth;
        this.status=status;
    }

    public User(UserRequest userRequest){
        this.userId=userRequest.getUserId();
        this.userPassword=userRequest.getUserPassword();
        this.userPhoneNumber=userRequest.getUserPhoneNumber();
        this.userName=userRequest.getUserName();
        this.userBirth=userRequest.getUserBirth();
        this.status=userRequest.getStatus();
    }

    public void update(UserRequest userRequest) {
        this.userPassword = userRequest.getUserPassword();
        this.userPhoneNumber = userRequest.getUserPhoneNumber();
        this.userName = userRequest.getUserName();
        this.userBirth = userRequest.getUserBirth();
        this.status=userRequest.getStatus();
    }

    public void matchPassword(String password) { //비밀번호 확인인
        if (!this.userPassword.equals(password)) {
            throw new IllegalArgumentException(INVALID_PASSWORD_MESSAGE);
        }
    }

    public boolean matchId(final String id) {
        return (id != null) && (id.equals(this.getUserId()));
    }
}
