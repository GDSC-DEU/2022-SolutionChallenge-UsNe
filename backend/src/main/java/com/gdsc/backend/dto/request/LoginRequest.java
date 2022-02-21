package com.gdsc.backend.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class LoginRequest {
    @Schema(description = "사용자의 아이디", nullable = true, example = "ujeong1009")
    @NotBlank(message = "아이디를 입력하세요!")
    private String userId;

    @Schema(description = "사용자의 비밀번호", nullable = true, example = "asdf1234")
    @NotBlank(message = "비밀번호를 입력하세요!")
    private String userPassword;

    @Builder
    public LoginRequest(String userId, String userPassword){
        this.userId=userId;
        this.userPassword=userPassword;
    }


}
