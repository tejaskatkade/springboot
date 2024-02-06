package com.project.BlogApp.service.implementation;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.BlogApp.entity.Categories;
import com.project.BlogApp.entity.Post;
import com.project.BlogApp.entity.User;
import com.project.BlogApp.exception.ResourceNotFoundException;
import com.project.BlogApp.paylod.PostDto;
import com.project.BlogApp.repository.CategoryRepo;
import com.project.BlogApp.repository.PostRepo;
import com.project.BlogApp.repository.UserRepo;
import com.project.BlogApp.service.PostService;

@Service
public class PostImpl implements PostService{
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PostRepo postRepo;
    
    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    UserRepo userRepo;


    @Override
    public PostDto createPost(Integer userId, Integer categoryId, PostDto PostDto) {

        Post post = modelMapper.map(PostDto, Post.class);
        
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User",userId));
        //post.setUser(modelMapper.map(userRepo.save(user),UserDto.class));
        Categories categories = categoryRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category",categoryId));
        //post.setCategories(modelMapper.map(categoryRepo.save(categories),Category.class));
        
        post.setUser(user);
        post.setCategories(categories);
        post.setDate(Date.valueOf("2024-02-06"));
        
        return modelMapper.map(postRepo.save(post),PostDto.class);
        
    
    
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        Post post = postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post",postId));
        post.setPost_id(postDto.getPost_id());
        post.setDate(postDto.getDate());
        post.setName(postDto.getName());
        post.setContent(postDto.getContent());
        post.setCategories(post.getCategories());
        post.setUser(post.getUser());

        return modelMapper.map(post , PostDto.class);
    }

    @Override
    public PostDto getPostById(Integer postId) {
        Post post = postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post",postId));
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public List<PostDto> getPostByCategory(Integer category_id) {
        Categories categories = categoryRepo.findById(category_id).orElseThrow(()->new ResourceNotFoundException("Category",category_id));
        List<Post> posts = postRepo.findByCategories(categories);
        return posts.stream().map(e->modelMapper.map(e, PostDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<PostDto> getPostByUser(Integer user_id) {
        User user = userRepo.findById(user_id).orElseThrow(()->new ResourceNotFoundException("User",user_id));
        List<Post> posts = postRepo.findByUser(user);
        return posts.stream().map(e->modelMapper.map(e, PostDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<PostDto> getPost() {
        List<Post> list = postRepo.findAll();
        return list.stream().map(e->modelMapper.map(e,PostDto.class)).collect(Collectors.toList());    }

    @Override
    public List<PostDto> searchPost(String keyword) {
        List<Post> posts = postRepo.findByNameContaining(keyword);
        return posts.stream().map(e->modelMapper.map(e,PostDto.class)).collect(Collectors.toList());
    }

    @Override
    public void deletePost(Integer postId) {
        Post post = postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post",postId));
        postRepo.delete(post);
    }
    
}
