package com.scm.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;
    private String about;
    private String profilePic;
    private String phoneNum;
    private boolean isValid = false;
    private Role role;
    private boolean emailVerified = false;
    private boolean phoneVerified = false;
    // SELF GOOGLE GITHUB
    private Provider provider = Provider.SELF;

}
