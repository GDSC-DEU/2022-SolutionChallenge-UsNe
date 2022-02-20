package com.gdsc.backend.service;

import com.gdsc.backend.domain.User;
import com.gdsc.backend.dto.request.UserRequest;
import com.gdsc.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public boolean joinCheck(UserRequest userRequest) {
        User findUser = userRepository.findByUserId(userRequest.getUserId());
        if (findUser == null) {
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public String join(UserRequest userRequest) throws NoSuchAlgorithmException {
        userRequest.passwordEncoding(encrypt(userRequest.toEntity().getUserPassword()));
        User user = userRequest.toEntity();
        User findUser = userRepository.findByUserId(user.getUserId());
        if (findUser == null) {
            userRepository.save(user);
            return user.getUserId();
        } else{
            return null;
        }
    }

    public static String encrypt(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] passByte = password.getBytes(StandardCharsets.UTF_8);
        md.reset();
        byte[] digested = md.digest(passByte);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; digested.length; i++) {
            sb.append(Integer.toHexString(0xff &amp; digested[i]));
        }
        return sb.toString();
    }

}