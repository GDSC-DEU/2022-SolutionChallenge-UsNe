package com.gdsc.backend.service;

import com.gdsc.backend.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.servlet.http.HttpSessionBindingListener;

@Getter
@ToString
@NoArgsConstructor
public class UserSession implements HttpSessionBindingListener {
    public static final String USER_SESSION_KEY = "loginUser";

    private String usreId;
    private String userName;

    @Builder
    private UserSession(String userId,String userName) {
        this.userName=userName;
        this.usreId=userId;
    }

    public static UserSession from(User user) {
        return UserSession.builder()
                .userId(user.getUserId())
                .userName(user.getUserName())
                .build();
    }

}
