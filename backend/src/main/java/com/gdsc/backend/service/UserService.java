package com.gdsc.backend.service;

import com.gdsc.backend.domain.User;
import com.gdsc.backend.dto.request.UserRequest;
import com.gdsc.backend.dto.response.SignUpResponse;
import com.gdsc.backend.dto.response.UserResponse;
import com.gdsc.backend.exception.*;
import com.gdsc.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private final UserRepository userRepository;

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
       try {
           if (joinCheck(userRequest) && samePwd(userRequest)) {
                User user = new User(userRequest);
                userRepository.save(user);

                return SignUpResponse.from(user);
           }
           else throw new SignUpFailException("올바르지 못한 가입");
       } catch (Exception e) {
           throw new SignUpFailException(e.getMessage());
       }
    }

    @Transactional
    public List<User> showUserList() {
        try{
            return userRepository.findAll();
        }catch (Exception e){
            throw new UserGetFailException(e.getMessage());
        }
    }

    @Transactional
    public SignUpResponse update(final UserRequest userRequest, String id) {
       try {
           User userinfo = userRepository.findUserByUserId(id);
           userinfo.update(userRequest);
           userRepository.save(userinfo);
           return SignUpResponse.from(userinfo);

       }catch(Exception e){
           throw new UserInfoUpdateFailException(e.getMessage());
       }
    }

    public boolean delete(final String id) { // 실험실험
       try {
           User user = userRepository.findUserByUserId(id);
           user.setStatus(false);
           return user.getStatus();
       }catch(Exception e){
           throw new UserInfoDeleteFailException(e.getMessage());
       }
    }


    public User findById(final String userId){
        return userRepository.findByUserId(userId);
    }

    public UserResponse findUserResponseById(final String userId) {
        return UserResponse.from(findById(userId));
    }

}