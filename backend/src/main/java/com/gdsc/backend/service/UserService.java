package com.gdsc.backend.service;

import com.gdsc.backend.domain.User;
import com.gdsc.backend.dto.request.UserRequest;
import com.gdsc.backend.dto.response.SignUpResponse;
import com.gdsc.backend.dto.response.UserResponse;
import com.gdsc.backend.exception.LoginFailException;
import com.gdsc.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private final UserRepository userRepository;
    //private Logger log;

   public boolean joinCheck(UserRequest userRequest) {
        User findUser = userRepository.findByUserId(userRequest.getUserId());
        User findPhoneNumber = userRepository.findByUserPhoneNumber(userRequest.getUserPhoneNumber());

        if (findUser == null && findPhoneNumber == null) {
            return true;
        } else {
            return false;
        }
   }

    public boolean samePwd(UserRequest userRequest) {
        final String p1 = "(\\w)\\1\\1\\1";
        String pwd = userRequest.getUserPassword();

        Matcher match = Pattern.compile(p1).matcher(pwd);

        return match.find() ? false : true;
    }

    @Transactional
    public SignUpResponse joinUser(UserRequest userRequest) {
        if (joinCheck(userRequest) && samePwd(userRequest)) {
            User user = new User(userRequest);
            userRepository.save(user);
            return SignUpResponse.from(user);
        }
      else{
            //log.info("not");
            return null;
        }
    }

    public User findById(final String userId){
        return userRepository.findByUserId(userId);
    }

    public UserResponse findUserResponseById(final String userId) {
        return UserResponse.from(findById(userId));
    }
}