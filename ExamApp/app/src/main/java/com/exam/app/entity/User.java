package com.exam.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;    
    private String userName;    
    private String email;
    private String password;
    private String phone;
    private String profile;
    private String role;

    private boolean enabled =true;

    

    public User() {
    }

    


    public String getRole() {
        return role;
    }




    public void setRole(String role) {
        this.role = role;
    }




    public User(Integer id, String name, String userName, String email, String password, String phone, String profile,String role,
            boolean enabled) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.profile = profile;
        this.enabled = enabled;
        this.role=role;
   }


    public Integer getId() {
        return id;
    }



    public void setId(Integer id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }



    public String getUserName() {
        return userName;
    }



    public void setUserName(String userName) {
        this.userName = userName;
    }



    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }



    public String getPassword() {
        return password;
    }



    public void setPassword(String password) {
        this.password = password;
    }



    public String getPhone() {
        return phone;
    }



    public void setPhone(String phone) {
        this.phone = phone;
    }



    public String getProfile() {
        return profile;
    }



    public void setProfile(String profile) {
        this.profile = profile;
    }



    public boolean isEnabled() {
        return enabled;
    }



    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }



  

    
     
}
