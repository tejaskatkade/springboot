package com.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.entity.MovieShow;

public interface ShowRepo extends JpaRepository<MovieShow,Integer> {

}
