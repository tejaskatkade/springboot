package com.example.exceltosql.entity;

import java.util.Date;
import java.time.Month;
import java.time.Year;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Finance {
    @Id
    private Double financeId;
    private String segment;
    private String country;
    private String product;
    private double unitsSole;
    private Date date;
   

    public Finance() {
    }

    public Finance(Double financeId, String segment, String country, String product, double unitsSole, Date date) {
        this.financeId= financeId;
        this.segment = segment;
        this.country = country;
        this.product = product;
        this.unitsSole = unitsSole;
        this.date = date;
    }

    
    public String getSegment() {
        return segment;
    }

    public void setSegment(String segment) {
        this.segment = segment;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getUnitsSole() {
        return unitsSole;
    }

    public void setUnitsSole(double unitsSole) {
        this.unitsSole = unitsSole;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getFinanceId() {
        return financeId;
    }

    public void setFinanceId(Double financeId) {
        this.financeId = financeId;
    }

    

    
}
