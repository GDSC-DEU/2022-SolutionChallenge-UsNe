package com.gdsc.backend.service;

import com.gdsc.backend.domain.User;
import com.gdsc.backend.dto.request.LoginRequest;
import com.gdsc.backend.exception.LoginFailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
@Service
@Transactional
public class LoginService {
    @Autowired
    private final UserService userService;

    public LoginService(final UserService userService){
        this.userService=userService;
    }

    public UserSession login(final LoginRequest loginRequest) {
        try {
            User user= userService.findById(loginRequest.getUserId());
            user.matchPassword(loginRequest.getUserPassword());
            return UserSession.from(user);
        } catch (Exception e) {
            throw new LoginFailException(e.getMessage());
        }
    }

    public void logout(final String userId) {
        User user = userService.findById(userId);
    }



}
