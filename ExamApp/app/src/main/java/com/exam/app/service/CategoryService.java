package com.exam.app.service;

import java.util.List;

import com.exam.app.entity.exam.Category;

public interface CategoryService {
    
    //add
    public Category addCategory(Category category);

    //update
    public Category updateCategory(Category category);

    //get
    public List<Category> getAllCategory();
    
    public Category getCategory(Long catId);

    //delete
    public void deleteCategory(Long catId);
}
