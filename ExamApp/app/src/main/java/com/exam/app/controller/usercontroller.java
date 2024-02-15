package com.exam.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.app.entity.User;
import com.exam.app.service.UserService;

@RestController
@RequestMapping("/user")
public class usercontroller {

    @Autowired
    UserService userService;

    // creating user
    @PostMapping("/")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // Get user
    @GetMapping("/{userName}")
    public User createUser(@PathVariable("userName") String userName) {
        return userService.getUser(userName);
    }

    // Get all user
    @GetMapping("/")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    // delete User
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);
    }

    // udate User
    @PutMapping("/{userName}")
    public User updateUser(@RequestBody User user, @PathVariable("userName") String userName) {
        return userService.updateUser(user, userName);
    }
}
