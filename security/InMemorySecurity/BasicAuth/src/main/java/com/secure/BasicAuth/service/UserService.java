package com.secure.BasicAuth.service;

import java.util.List;



import com.secure.BasicAuth.model.User;


public interface UserService {
    public void addUser();
    public List<User> getUser();
}
