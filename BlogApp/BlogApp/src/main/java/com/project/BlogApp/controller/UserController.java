package com.project.BlogApp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.BlogApp.paylod.UserDto;
import com.project.BlogApp.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    //post

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
       UserDto dto = userService.createUser(userDto);
       return new ResponseEntity<>(dto,HttpStatus.CREATED);
    }

    //put

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable("userId") Integer id){
        UserDto updatedUser = userService.updateUser(userDto, id);
        return ResponseEntity.ok(updatedUser);
    }


    //get
    @GetMapping("/get/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("userId") Integer id){
       UserDto dto = userService.getUserById(id);
       return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    @GetMapping("/get")
    public ResponseEntity<List<UserDto>> getUsers(){
       List<UserDto> users = userService.getAllUsers();
       return new ResponseEntity<>(users,HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") Integer id){
        
        deleteUser(id);
        return ResponseEntity.ok(Map.of("Message","User DeletedSuccessfully"));
    }
    
}
