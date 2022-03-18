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

    @Schema(description = "사용자 이름", nullable = false, example = "Content")
    private String userName;

    @Builder
    public UserResponse(String userId, String userName){
        this.userId=userId;
        this.userName=userName;
    }

    public static UserResponse from(User user) {
        UserResponse userResponse = UserResponse.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .build();
        return userResponse;
    }

}
