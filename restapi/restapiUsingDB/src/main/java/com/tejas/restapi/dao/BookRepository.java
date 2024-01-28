package com.tejas.restapi.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.tejas.restapi.entities.Book;
@Component
public interface BookRepository extends CrudRepository<Book,Integer>{
    
}
