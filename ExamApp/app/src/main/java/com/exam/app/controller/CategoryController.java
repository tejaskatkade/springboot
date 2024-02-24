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
import com.exam.app.entity.exam.Category;
import com.exam.app.service.CategoryService;


@RestController
@RequestMapping("/category")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;


    //add
    @PostMapping("/")
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        Category category1 = categoryService.addCategory(category);
        return ResponseEntity.ok(category1);
    }

    //update
    @PutMapping("/")
    public ResponseEntity<Category>  updateCategory(@RequestBody Category category){
        return ResponseEntity.ok(categoryService.updateCategory(category));
    }
    //get single
    @GetMapping("/{categoryId}")
    public ResponseEntity<Category>  getCategory(@PathVariable("categoryId") Long categoryId){
        return ResponseEntity.ok(categoryService.getCategory(categoryId));
    }
    //get all
    @GetMapping("/")
    public ResponseEntity<List<Category>>  getAllCategory(){
        return ResponseEntity.ok(categoryService.getAllCategory());
    }

    //delete
    @DeleteMapping("/{categoryId}")
    public void deleteQuiz(@PathVariable("categoryId") Long categoryId){
    categoryService.deleteCategory(categoryId);
    }    
}
