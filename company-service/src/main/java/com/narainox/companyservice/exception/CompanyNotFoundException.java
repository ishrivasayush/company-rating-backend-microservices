package com.narainox.companyservice.exception;

public class CompanyNotFoundException extends RuntimeException{
    private String job;
    private String type;
    private Object value;

    public CompanyNotFoundException(String job, String type, Object value) {
        super(String.format("%s not found with %s: %s",job,type,value));
        this.job = job;
        this.type = type;
        this.value = value;
    }
}
