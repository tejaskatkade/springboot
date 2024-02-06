package com.project.BlogApp.service;

import java.util.List;
import com.project.BlogApp.paylod.PostDto;

public interface PostService {
    PostDto createPost(Integer userId, Integer categoryId, PostDto PostDto);

    PostDto updatePost(PostDto postDto, Integer postId);

    PostDto getPostById(Integer postId);

    List<PostDto> getPostByCategory(Integer category_id);
    List<PostDto> getPostByUser(Integer user_id);
    List<PostDto> getPost();
    List<PostDto> searchPost(String keyword);
    void deletePost(Integer postId);

}
