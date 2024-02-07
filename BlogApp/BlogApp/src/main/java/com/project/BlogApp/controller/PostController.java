package com.project.BlogApp.controller;

import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.BlogApp.config.AppConstant;
import com.project.BlogApp.paylod.APIResponse;
import com.project.BlogApp.paylod.PostDto;
import com.project.BlogApp.paylod.PostResponse;
import com.project.BlogApp.service.PostService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    PostService postService;

    //get
    //v-1
    // @GetMapping("/all")
    // public ResponseEntity<List<PostDto>> getAllPost(){
    //     List<PostDto> postDto = postService.getAllPost();
    //     return new ResponseEntity<>(postDto,HttpStatus.FOUND);
    // }

    //v-2
    // @GetMapping("/all")
    // public ResponseEntity<List<PostDto>> getAllPost(
    //     @RequestParam(value = "pageNumber", defaultValue = "1", required = false) Integer pageNumber,
    //     @RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize
    // ){
    //     List<PostDto> postDto = postService.getAllPost(pageNumber,pageSize);
    //     return new ResponseEntity<>(postDto,HttpStatus.FOUND);
    // }

    //v-3
    @GetMapping("/all")
    public ResponseEntity<PostResponse> getAllPost(
        @RequestParam(value = "pageNumber", defaultValue = AppConstant.PAGE_NUMBER, required = false) Integer pageNumber,
        @RequestParam(value = "pageSize", defaultValue = AppConstant.PAGE_SIZE, required = false) Integer pageSize,
        @RequestParam(value = "sortBy", defaultValue = AppConstant.SORT_BY, required = false) String sortBy
    ){
        PostResponse postResponse = postService.getAllPost(pageNumber,pageSize,sortBy);
        return new ResponseEntity<>(postResponse,HttpStatus.FOUND);
    }

    @GetMapping("/{post_id}")
    public ResponseEntity<PostDto> getPost(@PathVariable Integer post_id){
        PostDto postDto = postService.getPostById(post_id);
        return new ResponseEntity<>(postDto,HttpStatus.FOUND);
    }
    @GetMapping("/get/user/{user_id}")
    public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer user_id){
        List<PostDto> list = postService.getPostByUser(user_id);
        return new ResponseEntity<>(list,HttpStatus.FOUND);
    }
    @GetMapping("/get/category/{category_id}")
    public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer category_id){
        List<PostDto> list = postService.getPostByCategory(category_id);
        return new ResponseEntity<>(list,HttpStatus.FOUND);
    }

    @GetMapping("/get/{keyword}")
    public ResponseEntity<List<PostDto>> serchInPosts(@PathVariable("keyword") String keyword){
        List<PostDto> postDtos = postService.searchPost(keyword);
        return new ResponseEntity<>(postDtos, HttpStatus.FOUND);
    }

    //post create
    @PostMapping("/post/user/{userId}/category/{categoryId}")
    public ResponseEntity<PostDto> createPost(
        @Valid
        @PathVariable Integer userId,
        @PathVariable Integer categoryId,
        @RequestBody PostDto postDto){
            
            PostDto pDto = postService.createPost(userId, categoryId, postDto);
            return new ResponseEntity<>(pDto, HttpStatus.CREATED);
    }

    //put  update

    @PutMapping("/put/{postId}")
    public ResponseEntity<PostDto> updatePost(
        @Valid 
        @PathVariable Integer postId,
        @RequestBody PostDto postDto){
            PostDto updatedPost = postService.updatePost(postDto, postId);
            return new ResponseEntity<>(updatedPost, HttpStatus.OK);
    }

   

    //delete
    @DeleteMapping("/delete/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Integer postId){
        postService.deletePost(postId);
        
        return new ResponseEntity<>(new APIResponse("Post Deleted Successfully", true),HttpStatus.OK);
    }




    
}
