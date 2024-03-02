package com.exam.app.exception;

public class ResourceExistException extends RuntimeException{
    public ResourceExistException(String message){
        super(message);
        //System.out.println(message);
    }
}
