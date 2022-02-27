package com.gdsc.backend.repository;

import com.gdsc.backend.domain.User;
import com.gdsc.backend.dto.request.UserRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUserId(String userId);
    //public User findByUserPassword(String userPassword);
    public User findByUserPhoneNumber(String userPhoneNumber);
    //List<User> findAll();
}