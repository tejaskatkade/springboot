package com.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.entity.Movie;

public interface MovieRepo extends JpaRepository<Movie,Integer>{

}
