package com.tejas;

import jakarta.persistence.Entity;
//import javax.persistence.Entity;
//import jakarta.persistence.Table;
import jakarta.persistence.Id;

//@Entity(name = "student_details")
//@Table(name = "mystudent")
@Entity  // to create table in database
public class Student {
    @Id //primary key 
    private int id;
    private String name;
    private String city;

    public Student(int id, String name, String city){
        super();
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public Student(){
        super();
    }

    public String toString(){
        return "Id : "+ id +"Name : "+ name +" City :"+ city;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }
    public String getCity(){
        return city;
    }
}
