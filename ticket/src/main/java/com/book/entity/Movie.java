package com.book.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Movie implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer movieId;
    
    private String description;
    private Integer durationInMin;
    private String language;
    private Date releaseDate;
    private String country;
    private String genere;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    List<MovieShow> movieShows = new ArrayList<>();



}
