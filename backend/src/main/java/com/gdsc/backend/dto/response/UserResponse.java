package com.gdsc.backend.dto.response;

import com.gdsc.backend.domain.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserResponse {
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

    @Builder
    public UserResponse(String userId, String userPassword, String userPhoneNumber, String userName, String userBirth){
        this.userId=userId;
        this.userPassword=userPassword;
        this.userPhoneNumber=userPhoneNumber;
        this.userName=userName;
        this.userBirth=userBirth;
    }

//    public static UserResponse from(User user) {
//        UserResponse userResponse = UserResponse.builder()
//                .userId(user.getUserId())
//                .userName(user.getUserName())
//                .build();
//        return userResponse;
//    }

    public static UserResponse from(User user) {
        UserResponse userResponse = UserResponse.builder()
                .userId(user.getUserPassword())
                .userPhoneNumber(user.getUserPhoneNumber())
                .userName(user.getUserName())
                .userBirth(user.getUserBirth())
                .build();
        return userResponse;
    }

}
