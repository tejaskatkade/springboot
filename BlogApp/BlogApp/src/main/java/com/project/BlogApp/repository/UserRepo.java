package com.project.BlogApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Service;

import com.project.BlogApp.entity.User;


public interface UserRepo extends JpaRepository<User, Integer> {

}
