package com.exam.app.Exceptions;

public class ResourceExistException extends RuntimeException{
    public ResourceExistException(String message){
        System.out.println(message);
    }
}
