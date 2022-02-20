package com.gdsc.backend.dto.request;

import com.gdsc.backend.domain.User;
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
    @NotBlank(message = "아이디를 입력하세요!")
    @Size(max = 10, message = "10자 이하로 입력하세요!")
    private String userId;

    @NotBlank(message = "비밀번호를 입력하세요!")
    @Size(min = 8, max = 20, message = "8자~20자 입력하세요!")
    // 특수문자 섞는거 알아보기
    private String userPassword;

    @NotBlank(message = "전화번호를 입력하세요!")
    @Pattern(regexp = "(01[016789])-?(\\d{3,4})-?(\\d{4})$", message = "올바른 휴대폰 번호를 입력해주세요. (ex) 01x-xxxx-xxxx)")
    private int userPhoneNumber;

    @NotBlank(message = "이름(닉네임)을 입력하세요!")
    private String userName;

    @Pattern(regexp = "^((19|20)\\d\\d)?([.])?(0[1-9]|1[012])([.])?(0[1-9]|[12][0-9]|3[01])$\n", message = "올바른 생년월일을 입력해주세요. (ex) xxxx.xx.xx)")
    private int userBirth;

    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    //private LocalDate joinDate;

    @Builder
    public UserRequest(String userId, String userPassword, int userPhoneNumber, String userName, int userBirth) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userPhoneNumber = userPhoneNumber;
        this.userName = userName;
        this.userBirth = userBirth;
    }

    public User toEntity() {
        User user = User.builder()
                .userId(userId)
                .userPassword(userPassword)
                .userPhoneNumber(userPhoneNumber)
                .userName(userName)
                .userBirth(userBirth)
                .build();
        return user;
    }

}
