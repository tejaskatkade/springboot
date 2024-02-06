package com.project.BlogApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.BlogApp.paylod.PostDto;
import com.project.BlogApp.service.PostService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    //get

    @GetMapping("/{post_id}")
    public ResponseEntity<PostDto> getPost(@PathVariable Integer post_id){
        PostDto postDto = postService.getPostById(post_id);
        return new ResponseEntity<>(postDto,HttpStatus.FOUND);
    }
    @GetMapping("/user/{user_id}")
    public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer user_id){
        List<PostDto> list = postService.getPostByUser(user_id);
        return new ResponseEntity<>(list,HttpStatus.FOUND);
    }
    @GetMapping("/category/{category_id}")
    public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer category_id){
        List<PostDto> list = postService.getPostByCategory(category_id);
        return new ResponseEntity<>(list,HttpStatus.FOUND);
    }

    //post create
    @PostMapping("/user/{userId}/category/{categoryId}")
    public ResponseEntity<PostDto> createPost(
        @Valid
        @PathVariable Integer userId,
        @PathVariable Integer categoryId,
        @RequestBody PostDto postDto){
            
            PostDto pDto = postService.createPost(userId, categoryId, postDto);
            return new ResponseEntity<>(pDto, HttpStatus.CREATED);
    }

    //put  update

   

    //delete


    
}
