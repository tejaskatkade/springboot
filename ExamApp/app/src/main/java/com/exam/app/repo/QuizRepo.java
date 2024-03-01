package com.exam.app.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.exam.app.entity.exam.Category;
import com.exam.app.entity.exam.Quiz;

public interface QuizRepo extends JpaRepository<Quiz,Long>{

    public List<Quiz>  findByCategory(Category category);
    public List<Quiz>  findByActive(Boolean b);
    public List<Quiz>  findByCategoryAndActive(Category category,Boolean b);
}
