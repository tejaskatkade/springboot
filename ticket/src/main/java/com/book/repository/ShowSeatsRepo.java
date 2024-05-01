package com.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.entity.ShowSeats;

public interface ShowSeatsRepo extends JpaRepository<ShowSeats,Integer>{

}
