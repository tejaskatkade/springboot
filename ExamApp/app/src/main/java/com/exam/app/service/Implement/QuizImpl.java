package com.exam.app.service.Implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.app.entity.exam.Category;
import com.exam.app.entity.exam.Quiz;
import com.exam.app.exception.ResourceNotFoundException;
import com.exam.app.repo.CategoryRepo;
import com.exam.app.repo.QuizRepo;
import com.exam.app.service.QuizService;

@Service
public class QuizImpl implements QuizService{

    @Autowired
    private QuizRepo quizRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Quiz addQuiz(Quiz quiz) {
        return quizRepo.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        Long id = quiz.getQid();
        quizRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Quiz", id));
        return quizRepo.save(quiz);
    }

    @Override
    public Quiz getQuiz(Long quizId) {
        return quizRepo.findById(quizId).orElseThrow(()->new ResourceNotFoundException("Quiz", quizId));
    }

    @Override
    public List<Quiz> getAllQuiz() {
        return quizRepo.findAll();
    }

    @Override
    public void deleteQuiz(Long quizId) {
        quizRepo.findById(quizId).orElseThrow(()->new ResourceNotFoundException("Quiz",quizId));
        
        quizRepo.deleteById(quizId);
    }

    @Override
    public List<Quiz> getQuizByCategory(Long catID) {
        Category category = categoryRepo.findById(catID).orElseThrow(()->new ResourceNotFoundException("Category", catID));
        return quizRepo.findByCategory(category);
    }

    @Override
    public List<Quiz> getActiveQuiz() {
        return quizRepo.findByActive(true);    
    }

    @Override
    public List<Quiz> getActiveQuizByCategory(Long catID) {
        Category category = categoryRepo.findById(catID).orElseThrow(()->new ResourceNotFoundException("Category", catID));
        return quizRepo.findByCategoryAndActive(category, true); 
    }
    
}
