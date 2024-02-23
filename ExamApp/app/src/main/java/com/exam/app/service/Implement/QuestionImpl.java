package com.exam.app.service.Implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.exam.app.entity.exam.Question;
import com.exam.app.entity.exam.Quiz;
import com.exam.app.repo.QuestionRepo;
import com.exam.app.service.QuestionService;

public class QuestionImpl implements QuestionService{

    @Autowired
    private QuestionRepo questionRepo;

    @Override
    public Question addQuestion(Question question) {
        return questionRepo.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return questionRepo.save(question);
    }

    @Override
    public Question getQuestion(Long queId) {
        return questionRepo.findById(queId).get();
    }

    @Override
    public List<Question> getAllQuestion() {
        return questionRepo.findAll();
    }

    @Override
    public List<Question> getQuestionOfQuiz(Quiz quiz) {
    
        return questionRepo.findByQuiz(quiz);
    }

    @Override
    public void deleteQuestion() {
    }
    
}
