package com.secure.JWTAuth.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.secure.JWTAuth.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String userName);
}
