package com.book.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class CinemaHalls implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hallId;    
    private String hallName;
    private Integer totalSeats;
    
    @JoinColumn(name = "cinemaId")
    private Cinema cinema;

    @OneToMany(mappedBy = "cinemaHalls", cascade = CascadeType.ALL)
    List<MovieShow> movieShows = new ArrayList<>(); 
}
