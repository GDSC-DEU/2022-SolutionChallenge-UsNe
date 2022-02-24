package com.gdsc.backend.service;

import com.gdsc.backend.domain.User;
import com.gdsc.backend.dto.request.UserRequest;
import com.gdsc.backend.dto.response.UserResponse;
import com.gdsc.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(final UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public boolean joinCheck(UserRequest userRequest) {
        User findUser = userRepository.findByUserId(userRequest.getUserId());
        User findPhoneNumber = userRepository.findByUserPhoneNumber(userRequest.getUserPhoneNumber());

        if (findUser == null && findPhoneNumber == null) {
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public String join(UserRequest userRequest) throws NoSuchAlgorithmException {
        User user = userRequest.toEntity();
        User findUser = userRepository.findByUserId(user.getUserId());
        User findPhoneNumber = userRepository.findByUserPhoneNumber(user.getUserPhoneNumber());

        if (findUser == null && findPhoneNumber == null) {
            userRepository.save(user);
            return user.getUserId();
        } else{
            return null;
        }
    }

    @Transactional
    public User findById(final String userId){
        return userRepository.findByUserId(userId);
    }

    @Transactional
    public UserResponse findUserResponseById(final String userId) {
        return UserResponse.from(findById(userId));
    }

}