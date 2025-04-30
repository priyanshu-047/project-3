package com.techcom.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class handler {
         
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> handleException(Exception e){
        System.out.println("error "+e);
        return new ResponseEntity<>(e.getLocalizedMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
   
}
