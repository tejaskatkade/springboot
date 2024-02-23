package com.exam.app.service;

import java.util.List;

import com.exam.app.entity.exam.Quiz;

public interface QuizService {
   public Quiz addQuiz(Quiz quiz); 
   public Quiz updateQuiz(Quiz quiz); 
   public Quiz getQuiz(Long quizId); 
   public List<Quiz> getAllQuiz(); 
   public void deleteQuiz(Long quizId); 
}
