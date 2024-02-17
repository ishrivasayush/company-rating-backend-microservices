package com.narainox.jobservice.exception;

public class JobNotFoundException extends RuntimeException{
    private String job;
    private String type;
    private Object value;

    public JobNotFoundException(String job, String type, Object value) {
        super(String.format("%s not found with %s: %s",job,type,value));
        this.job = job;
        this.type = type;
        this.value = value;
    }
}
