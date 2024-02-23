package com.secure.BasicAuth.controller;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.secure.BasicAuth.model.User;
import com.secure.BasicAuth.service.UserService;

@RestController
@RequestMapping("/home")
public class HomeController {
    
    @Autowired
    UserService userService;
    //Get Mapping

    @GetMapping("/")
    public List<User> getUser(){
        userService.addUser();
        return this.userService.getUser();
    }
    
    // Principle represent logged in user
    @GetMapping("/current")
    public String getLoggedInUser(Principal principal){
        return principal.getName();
    }
}
