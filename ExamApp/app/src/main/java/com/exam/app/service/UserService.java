package com.exam.app.service;

import java.util.List;

import com.exam.app.entity.User;

public interface UserService {

    // creating user
    public User createUser(User user);

    // getting user by userName
    public User getUser(String userName);

    // getting all user
    public List<User> getAllUser();

    // Delete User
    public void deleteUser(Long id);

    // updating user
    public User updateUser(User user, String userName);
}
