package com.exam.app.service.Implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.app.entity.exam.Category;
import com.exam.app.exception.ResourceNotFoundException;
import com.exam.app.repo.CategoryRepo;
import com.exam.app.service.CategoryService;

@Service
public class CategoryImpl implements CategoryService{


    @Autowired
    private CategoryRepo categoryRepo;
    
    @Override
    public Category addCategory(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public Category updateCategory(Category category){
        Long cid = category.getCid();
        categoryRepo.findById(cid).orElseThrow(()->new ResourceNotFoundException("Category", cid));
        return categoryRepo.save(category);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepo.findAll();
    }

    @Override
    public Category getCategory(Long catId) {
        return categoryRepo.findById(catId).orElseThrow(()->new ResourceNotFoundException("Category", catId));
    }

    @Override
    public void deleteCategory(Long catId) {
        categoryRepo.findById(catId).orElseThrow(()->new ResourceNotFoundException("Category", catId));
        categoryRepo.deleteById(catId);
    }
    
}
