package com.secure.JWTAuth.service.Implement;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.secure.JWTAuth.repo.UserRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{


    private final UserRepo userRepo;
    

    public UserDetailsServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("Username Not Found Exception"));
    }
    
}
