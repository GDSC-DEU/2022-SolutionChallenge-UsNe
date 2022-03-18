package com.gdsc.backend.dto.response;

import com.gdsc.backend.domain.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class SignUpResponse {
    @Schema(description = "사용자 아이디", nullable = false, example = "Content")
    private String userId;

    @Schema(description = "사용자 비밀번호", nullable = false, example = "Content")
    private String userPassword;

    @Schema(description = "사용자 휴대전화번호", nullable = false, example = "Content")
    private String userPhoneNumber;

    @Schema(description = "사용자 이름", nullable = false, example = "Content")
    private String userName;

    @Schema(description = "사용자 생일", nullable = false, example = "Content")
    private String userBirth;

    @Schema(description = "활동 가능 상태", nullable = false, example = "True")
    private Boolean status;

    @Builder
    public SignUpResponse(String userId, String userPassword, String userPhoneNumber, String userName, String userBirth, Boolean status){
        this.userId=userId;
        this.userPassword=userPassword;
        this.userPhoneNumber=userPhoneNumber;
        this.userName=userName;
        this.userBirth=userBirth;
        this.status=status;
    }

    public static SignUpResponse from(User user) {
        SignUpResponse signUpResponse = SignUpResponse.builder()
                .userId(user.getUserId())
                .userPhoneNumber(user.getUserPhoneNumber())
                .userName(user.getUserName())
                .userBirth(user.getUserBirth())
                .status(user.getStatus())
                .build();
        return signUpResponse;
    }
}
