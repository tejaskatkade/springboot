package com.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.entity.Cinema;

public interface CinemaRepo extends JpaRepository<Cinema, Integer> {

}
