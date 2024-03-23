package com.bajaj.bookmyplace.controllers;


import com.bajaj.bookmyplace.exceptions.CommonException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.HashMap;
import java.util.Map;


@ControllerAdvice
public class ExceptionController {

    @org.springframework.web.bind.annotation.ExceptionHandler({CommonException.class})
    public ResponseEntity<Object> handleEntityNotFound(CommonException entityNotFoundException){
        Map<String, Object> response = new HashMap<>();
        response.put("message", entityNotFoundException.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}


