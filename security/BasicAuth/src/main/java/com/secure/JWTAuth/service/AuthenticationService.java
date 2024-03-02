package com.secure.JWTAuth.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.secure.JWTAuth.model.JwtResponse;
import com.secure.JWTAuth.model.User;
import com.secure.JWTAuth.repo.UserRepo;
import com.secure.JWTAuth.security.JwtHelper;

@Service
public class AuthenticationService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtHelper jwtHelper;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepo userRepo, PasswordEncoder passwordEncoder, JwtHelper jwtHelper) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtHelper = jwtHelper;
        this.authenticationManager = null;
    }

    public JwtResponse register(User request) {

        User user = new User();
        user.setName(request.getName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        user.setUserId(request.getUserId());
        user.setUsername(request.getUsername());
        user = userRepo.save(user);

        String token = jwtHelper.generateToken(user);
        return new JwtResponse(token);
    }

    public JwtResponse authenticate(User request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()));

        User user = userRepo.findByUsername(request.getUsername()).get();
        String token = jwtHelper.generateToken(user);

        return new JwtResponse(token);

    }

}
