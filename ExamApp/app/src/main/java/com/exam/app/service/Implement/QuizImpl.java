package com.exam.app.service.Implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.exam.app.entity.exam.Quiz;
import com.exam.app.repo.QuizRepo;
import com.exam.app.service.QuizService;

public class QuizImpl implements QuizService{

    @Autowired
    private QuizRepo quizRepo;

    @Override
    public Quiz addQuiz(Quiz quiz) {
        return quizRepo.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return quizRepo.save(quiz);
    }

    @Override
    public Quiz getQuiz(Long quizId) {
        return quizRepo.findById(quizId).get();
    }

    @Override
    public List<Quiz> getAllQuiz() {
        return quizRepo.findAll();
    }

    @Override
    public void deleteQuiz(Long quizId) {
        quizRepo.deleteById(quizId);
    }
    
}
