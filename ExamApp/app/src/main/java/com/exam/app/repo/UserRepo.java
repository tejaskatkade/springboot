package com.exam.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.app.entity.User;

public interface UserRepo extends JpaRepository<User, Long>{

    User findByUserName(String userName);
    
}
