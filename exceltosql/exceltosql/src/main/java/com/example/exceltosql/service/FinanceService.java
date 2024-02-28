package com.example.exceltosql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.exceltosql.entity.Finance;
import com.example.exceltosql.helper.Helper;
import com.example.exceltosql.repos.FinanceRepo;

@Service
public class FinanceService {

    @Autowired
    FinanceRepo financeRepo;

    public void save(MultipartFile file){
        try {
            List<Finance> finances = Helper.convertExcelTOList(file.getInputStream());
            financeRepo.saveAll(finances);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Finance> getAllFinances(){
        return financeRepo.findAll();

    }
}
