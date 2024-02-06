package com.project.BlogApp.paylod;

import java.sql.Date;


import com.project.BlogApp.entity.Categories;
import com.project.BlogApp.entity.User;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

    private Integer post_id;
    @NotEmpty
    @Size(min = 3)
    private String name;
    @NotEmpty
    @Size(min = 3, max = 100)
    private String content;
    private Date date;
    @NotNull
    private Categories categories;
    @NotNull
    private User user;
}
