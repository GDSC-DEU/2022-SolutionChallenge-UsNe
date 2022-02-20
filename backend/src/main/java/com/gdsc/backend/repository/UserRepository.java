package com.gdsc.backend.repository;

import com.gdsc.backend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUserId(String userId);
    public User findByUserPhoneNumber(int userPhoneNumber);
}