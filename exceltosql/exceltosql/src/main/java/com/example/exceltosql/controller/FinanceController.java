package com.example.exceltosql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.exceltosql.entity.Finance;
import com.example.exceltosql.helper.Helper;
import com.example.exceltosql.service.FinanceService;

@RestController
@RequestMapping("/finance")
public class FinanceController {
    
    @Autowired
    FinanceService financeService;
    
    
    @GetMapping("/")
    public ResponseEntity<List<Finance>> getAllFinances(){
        return ResponseEntity.ok(financeService.getAllFinances());
    }

    @PostMapping("/")
    public ResponseEntity<?> uploadExcelToDb(@RequestParam("file") MultipartFile file){
       // if(Helper.checkFile(file)){
             financeService.save(file);
            return ResponseEntity.status(HttpStatus.OK).body("File is Uploaded and data is save to db");
        //}
        //return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File format is not excel");
        
    }
}