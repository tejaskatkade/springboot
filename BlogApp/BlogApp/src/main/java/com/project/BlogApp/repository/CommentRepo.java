package com.project.BlogApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.BlogApp.entity.Comment;

public interface CommentRepo extends JpaRepository<Comment,Integer> {
    
}
