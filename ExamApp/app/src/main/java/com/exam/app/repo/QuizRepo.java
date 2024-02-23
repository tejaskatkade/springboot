package com.exam.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.app.entity.exam.Quiz;

public interface QuizRepo extends JpaRepository<Quiz,Long>{
}
