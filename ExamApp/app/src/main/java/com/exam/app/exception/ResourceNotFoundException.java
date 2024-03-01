package com.exam.app.exception;

public class ResourceNotFoundException extends RuntimeException {
    
    public ResourceNotFoundException(String resource, Long id) {
        
        super(resource+" with id : "+ id +" not found !!");
    } 
}
