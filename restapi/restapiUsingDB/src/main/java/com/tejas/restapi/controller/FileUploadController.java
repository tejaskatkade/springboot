package com.tejas.restapi.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tejas.restapi.helper.FileUploadHelper;

@RestController
public class FileUploadController {

    @Autowired
    private FileUploadHelper fileUploadHelper; 
    
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("sinhgadimg") MultipartFile file){

        //validation

        System.out.println("OriginalFilename : "+file.getOriginalFilename());
        // System.out.println("ContentType : "+file.getContentType());
        System.out.println("Name : "+file.getName());
        System.out.println("Size : "+file.getSize());

        if(file.isEmpty()){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File is Empty ...!");
        }
        
        if(!file.getContentType().equals("image/jpeg")){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Not a image/jpeg");
        }

        // Uploading file
        boolean val = fileUploadHelper.uploadFile(file);
        if(val){
            //return ResponseEntity.ok("File Uploaded Successfully");
            return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
            //ServletUriComponentsBuilder.fromCurrentContextPath()  : gives path  "localhost://8080"
            //path("\\image\\") : gives \\image\\
            //path(file.getOriginalFilename()) : gives the file name which is uploaded.
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
    } 
}
