package com.project.BlogApp.paylod;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Use to transfer data

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    private int id;
    private String name;
    private String email;
    private String password;
    private String about;

}
