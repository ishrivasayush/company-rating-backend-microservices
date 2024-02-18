package com.narainox.reviewservice.exception;

public class ReviewNotFoundException extends RuntimeException{
    private String job;
    private String type;
    private Object value;

    public ReviewNotFoundException(String job, String type, Object value) {
        super(String.format("%s not found with %s: %s",job,type,value));
        this.job = job;
        this.type = type;
        this.value = value;
    }
}
