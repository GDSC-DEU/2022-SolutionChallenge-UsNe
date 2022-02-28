package com.gdsc.backend.dto.request;

import com.gdsc.backend.domain.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class UserRequest {
    @Schema(description = "사용자의 아이디", nullable = false, example = "ujeong1009")
    @NotBlank(message = "아이디를 입력하세요!")
    @Size(max = 10, message = "10자 이하로 입력하세요!")
    @Pattern(regexp = "(?=\\w)[\\w]{1,10}$")
    private String userId;

    @Schema(description = "사용자의 비밀번호", nullable = false, example = "asdf1234")
    @NotBlank(message = "비밀번호를 입력하세요!")
    @Pattern(regexp = "(?=.*[a-zA-Z])(?=.*[\\d])(?=.*[~!@#$%^&*])[a-zA-Z\\d~!@#$%^&*]{8,20}$", message = "비밀번호 조건을 만족해주세요!")
    @Size(min = 8, max = 20, message = "8자~20자 입력하세요!")
    private String userPassword;

    @Schema(description = "사용자의 전화번호", nullable = false, example = "010-2546-7788")
    @NotBlank(message = "전화번호를 입력하세요!")
    @Pattern(regexp = "(01[016789])-?(\\d{3,4})-?(\\d{4})$", message = "올바른 휴대폰 번호를 입력해주세요. (ex) 01x-xxxx-xxxx)")
    private String userPhoneNumber;

    @Schema(description = "사용자의 이름", nullable = true, example = "남지정")
    @NotBlank(message = "이름(닉네임)을 입력하세요!")
    private String userName;

    @Schema(description = "사용자의 생일", nullable = true, example = "2000.12.24")
    @Pattern(regexp = "((19|20)\\d{2}).?(0[1-9]|1[0-2]).?(0[1-9]|[1-2][0-9]|3[0-1])$", message = "올바른 생년월일을 입력해주세요. (ex) xxxx.xx.xx)")
    private String userBirth;

    @Builder
    public UserRequest(String userId, String userPassword, String userPhoneNumber, String userName, String userBirth) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userPhoneNumber = userPhoneNumber;
        this.userName = userName;
        this.userBirth = userBirth;
    }

    public User toEntity() {
        return User.builder()
                .userId(userId)
                .userPassword(userPassword)
                .userPhoneNumber(userPhoneNumber)
                .userName(userName)
                .userBirth(userBirth)
                .build();
    }
}
