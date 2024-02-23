package com.exam.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.app.entity.exam.Category;

public interface CategoryRepo extends JpaRepository<Category,Long>{

    
}
