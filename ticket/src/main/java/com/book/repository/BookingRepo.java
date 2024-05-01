package com.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.entity.Booking;

public interface BookingRepo extends JpaRepository<Booking, Integer> {

}
