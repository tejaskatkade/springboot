package com.exam.app.service;

import java.util.List;
import com.exam.app.entity.exam.Question;

public interface QuestionService {
    public Question addQuestion(Question question);
    public Question updateQuestion(Question question);
    public Question getQuestion(Long queId);
    public List<Question> getAllQuestion();
    public List<Question> getQuestionOfQuiz(Long quizId);
    public void deleteQuestion(Long qId);
}
