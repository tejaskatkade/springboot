package com.project.BlogApp.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(int id) {
        super("User with id = " + id + " not found");
    }

}
