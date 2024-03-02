package com.exam.app.service.Implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.app.entity.User;
import com.exam.app.exception.ResourceExistException;
import com.exam.app.repo.UserRepo;
import com.exam.app.service.UserService;

@Service
public class UserImpl implements UserService{

    @Autowired
    UserRepo userRepo;


    // create user
    @Override
    public User createUser(User user) {

        User isExist = userRepo.findByUserName(user.getUserName());

        if(isExist != null){
            System.out.println("Username Exist");
            throw new ResourceExistException("User already exist in database");
    
        }else{
            userRepo.save(user);
        }
        return user;
    }

    // get user
    @Override
    public User getUser(String userName){
        User user = userRepo.findByUserName(userName);

        if(user == null){
            System.out.println("Username Not Exist");
            return null;
        }else{
            return user;
        }
    }

    //Override
    public List<User> getAllUser(){
        return userRepo.findAll();
    }

    //Delete User
    @Override
    public void deleteUser(Long id){
        userRepo.deleteById(id);
    }

    //update User
    @Override

    public User updateUser(User user ,String UserName){
        User user1 = userRepo.findByUserName(UserName);
        user1.setUserName(user.getUserName());
        user1.setEmail(user.getEmail());
        user1.setName(user.getName());
        user1.setPassword(user.getPassword());
        user1.setPhone(user.getPhone());
        user1.setProfile(user.getProfile());

        userRepo.save(user1);
        
        return user1;
    }
    
}
