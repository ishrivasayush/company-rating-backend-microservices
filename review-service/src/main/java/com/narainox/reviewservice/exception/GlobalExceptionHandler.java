package com.narainox.reviewservice.exception;


import com.narainox.reviewservice.utils.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ReviewNotFoundException.class)
    public ResponseEntity<APIResponse> JobNotFoundHandler(ReviewNotFoundException jobNotFoundException)
    {
        APIResponse apiResponse=new APIResponse();
        apiResponse.setMessage(jobNotFoundException.getMessage());
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }
}
