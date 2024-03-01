package com.exam.app.exception;

public class ResourceExistException extends RuntimeException{
    public ResourceExistException(String message){
        System.out.println(message);
    }
}
