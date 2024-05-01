package com.book.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieShow implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer showId;

    private Time starTime;
    private Time endTime;
    private Date date;
    private Integer availableSeats;

    @JoinColumn(name = "movieId")
    private Movie movie;

    @JoinColumn(name = "hallId")
    private CinemaHalls cinemaHalls;

    @OneToMany(mappedBy = "movieShow", cascade = CascadeType.ALL)
    List<ShowSeats> seats = new ArrayList<>();

    @OneToMany(mappedBy = "movieShow", cascade = CascadeType.ALL)
    List<Booking> bookings = new ArrayList<>();
}
