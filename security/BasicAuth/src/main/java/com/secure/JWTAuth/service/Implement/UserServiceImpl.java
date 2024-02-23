package com.secure.JWTAuth.service.Implement;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.secure.JWTAuth.model.User;
import com.secure.JWTAuth.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    List<User> list = new ArrayList<>();

    @Override
    public void addUser() {
        list.add(new User( 122,"Tejas katkade", "tk@gmail.com", "12345"));
        list.add(new User(123,"Virat Kohli", "vk@gmail.com", "67890"));
        list.add(new User(124,"Sachin Tendulkar", "st@gmail.com", "11121314"));
        list.add(new User(125,"MahendraSingh Dhoni", "msd@gmail.com", "15161718"));
        
    }

    @Override
    public List<User> getUser() {
        return list;
    }
    
}
