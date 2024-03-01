package com.exam.app.service.Implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.app.entity.exam.Question;
import com.exam.app.entity.exam.Quiz;
import com.exam.app.exception.ResourceNotFoundException;
import com.exam.app.repo.QuestionRepo;
import com.exam.app.repo.QuizRepo;
import com.exam.app.service.QuestionService;

@Service
public class QuestionImpl implements QuestionService{

    @Autowired
    private QuestionRepo questionRepo;
    @Autowired
    private QuizRepo quizRepo;

    @Override
    public Question addQuestion(Question question) {
        return questionRepo.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        Long id = question.getQuesId();
        questionRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Question", id));
        return questionRepo.save(question);
    }

    @Override
    public Question getQuestion(Long queId) {
        return questionRepo.findById(queId).orElseThrow(()->new ResourceNotFoundException("Question", queId));
    }

    @Override
    public List<Question> getAllQuestion() {
        return questionRepo.findAll();
    }

    @Override
    public List<Question> getQuestionOfQuiz(Long quizId) {
        Quiz quiz = quizRepo.findById(quizId).orElseThrow(()->new ResourceNotFoundException("Quiz", quizId));
        return questionRepo.findByQuiz(quiz);
    }

    @Override
    public void deleteQuestion(Long qId) {
        questionRepo.deleteById(qId);
    }
    
}
