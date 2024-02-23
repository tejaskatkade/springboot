package com.exam.app.entity.exam;

import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;

    private String title;

    private String description;


    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Quiz>  quizes = new LinkedHashSet<>();
    

    public Category(){

    }


    public Category(Long cid, String title, String description, Set<Quiz> quizes) {
        this.cid = cid;
        this.title = title;
        this.description = description;
        this.quizes = quizes;
    }


    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Set<Quiz> getQuizes() {
        return quizes;
    }


    public void setQuizes(Set<Quiz> quizes) {
        this.quizes = quizes;
    }
}
