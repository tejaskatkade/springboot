package com.secure.JWTAuth.service;

import java.util.List;

import com.secure.JWTAuth.model.User;


public interface UserService {
    public void addUser();
    public List<User> getUser();
}
