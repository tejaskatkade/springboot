package com.example.exceltosql.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.exceltosql.entity.Finance;

public interface FinanceRepo extends JpaRepository<Finance,Double>{
    
}
