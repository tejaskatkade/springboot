package com.exam.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.app.entity.exam.Question;
import com.exam.app.entity.exam.Quiz;

public interface QuestionRepo extends JpaRepository<Question,Long>{

    List<Question> findByQuiz(Quiz quiz);
    
}
