package com.exam.app.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.app.entity.exam.Question;
import com.exam.app.entity.exam.Quiz;
import com.exam.app.service.QuestionService;
import com.exam.app.service.QuizService;

@RestController
@RequestMapping("que")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuizService quizService;
    //add
    @PostMapping("/")
    public ResponseEntity<Question>  addQue(@RequestBody Question que){
        return ResponseEntity.ok(questionService.addQuestion(que));
    }
    //update
    @PutMapping("/")
    public ResponseEntity<Question>  updateQue(@RequestBody Question que){
        return ResponseEntity.ok(questionService.updateQuestion(que));
    }
    //get single
    @GetMapping("/{queId}")
    public ResponseEntity<Question>  getQue(@PathVariable("queId") Long queId){
        return ResponseEntity.ok(questionService.getQuestion(queId));
    }
    //get all
    @GetMapping("/")
    public ResponseEntity<List<Question>>  getAllQue(){
        return ResponseEntity.ok(questionService.getAllQuestion());
    }

    //get que by quiz
    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<List<Question>>  getAllQueByQuiz(@PathVariable("quizId")  Long quizId){
        
        // Quiz quiz = quizService.getQuiz(quizId);
        // return ResponseEntity.ok(questionService.getQuestionOfQuiz(quiz));

        Quiz quiz = quizService.getQuiz(quizId);
        List<Question> list1 = questionService.getQuestionOfQuiz(quizId);
        int size = Integer.parseInt(quiz.getNumberOfQuestion());
        if(list1.size() > size ){
            List<Question> list2 = new ArrayList<>();
            Collections.shuffle(list1);
            list2 = list1.subList(0, size+1);
            return ResponseEntity.ok(list2);
        }

        return ResponseEntity.ok(list1);

    }

   

    //delete

    @DeleteMapping("/{queId}")
    public void deleteQuiz(@PathVariable("queId") Long queId){
        questionService.deleteQuestion(queId);
    }
}
