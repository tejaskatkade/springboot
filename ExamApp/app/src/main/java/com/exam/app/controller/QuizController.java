package com.exam.app.controller;

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
import com.exam.app.entity.exam.Quiz;
import com.exam.app.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    @Autowired
    private QuizService quizService;


    //add
    @PostMapping("/")
    public ResponseEntity<Quiz>  addQuiz(@RequestBody Quiz quiz){
        return ResponseEntity.ok(quizService.addQuiz(quiz));
    }
    
    //update
    @PutMapping("/")
    public ResponseEntity<Quiz>  updateQuiz(@RequestBody Quiz quiz){
        return ResponseEntity.ok(quizService.updateQuiz(quiz));
    }
    

    //delete
    @DeleteMapping("/{quizId}")
    public void deleteQuiz(@PathVariable("quizId") Long quizId){
    quizService.deleteQuiz(quizId);
    }

    //get

    //get single
    @GetMapping("/{quizId}")
    public ResponseEntity<Quiz>  getQuiz(@PathVariable("quizId") Long quizId){
        return ResponseEntity.ok(quizService.getQuiz(quizId));
    }
    //get all
    @GetMapping("/")
    public ResponseEntity<List<Quiz>>  getAllQuiz(){
        return ResponseEntity.ok(quizService.getAllQuiz());
    }

    @GetMapping("/active")
    public ResponseEntity<List<Quiz>>  getActiveQuizes(){
        return ResponseEntity.ok(quizService.getActiveQuiz());
    }

    @GetMapping("/category/{cId}")
    public ResponseEntity<List<Quiz>>  getQuizesByCategory(
        @PathVariable("cId") Long cId
    ){
        return ResponseEntity.ok(quizService.getQuizByCategory(cId));
    }
    @GetMapping("/active/category/{cId}")
    public ResponseEntity<List<Quiz>>  getActiveQuizesByCategory(
        @PathVariable("cId") Long cId
    ){
        return ResponseEntity.ok(quizService.getActiveQuizByCategory(cId));
    }

    
}
