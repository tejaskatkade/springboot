package com.exam.app.service.Implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.app.Exceptions.ResourceExistException;
import com.exam.app.entity.User;
import com.exam.app.repo.UserRepo;
import com.exam.app.service.UserService;

@Service
public class UserImpl implements UserService{

    @Autowired
    UserRepo userRepo;


    @Override
    public User createUser(User user) {

        User isExist = userRepo.findByUserName(user.getUserName());

        if(isExist != null){
            System.out.println("Username Exist");
            throw new ResourceExistException("User already eXist in database");
    
        }else{
            userRepo.save(user);
        }
        return user;
    }
    
}
