package com.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.entity.CinemaHalls;

public interface CinemaHallsRepo extends JpaRepository<CinemaHalls, Integer>{

}
