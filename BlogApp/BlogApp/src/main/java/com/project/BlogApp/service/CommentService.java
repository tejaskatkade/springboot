package com.project.BlogApp.service;

import com.project.BlogApp.paylod.CommentDto;

public interface CommentService {
    CommentDto createComment(CommentDto commentDto, Integer UserId, Integer useId);
   // CommentDto getComment();
    void deleteComment(Integer commentId);
    
}
