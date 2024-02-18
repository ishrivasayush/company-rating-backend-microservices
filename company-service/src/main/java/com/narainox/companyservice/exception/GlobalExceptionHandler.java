package com.narainox.companyservice.exception;


import com.narainox.companyservice.utils.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CompanyNotFoundException.class)
    public ResponseEntity<APIResponse> JobNotFoundHandler(CompanyNotFoundException jobNotFoundException)
    {
        APIResponse apiResponse=new APIResponse();
        apiResponse.setMessage(jobNotFoundException.getMessage());
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }
}
