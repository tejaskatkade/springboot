package com.tejas.SpringJpaProj.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String city;
    private String status;

    public User(){
        super();
    }

    public User(int id, String name, String city, String status){
        super();
        this.id = id;
        this.name = name;
        this.city = city;
        this.status = status;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String  getName(){
        return name;
    }
    public void setCity(String city){
        this.city = city;
    }

    public String  getCity(){
        return city;
    }
    public void setStatus(String status){
        this.status = status;
    }

    public String  getStatus(){
        return status ;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", city=" + city + ", status=" + status + "]";
    }

}
