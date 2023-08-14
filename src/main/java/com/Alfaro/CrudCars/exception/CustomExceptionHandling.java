package com.Alfaro.CrudCars.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class CustomExceptionHandling {
    public CustomExceptionHandling() {
    }

    @ExceptionHandler({CarNotFoundException.class})
    public ResponseEntity<Object> handleCarNotFoundException(CarNotFoundException exception, WebRequest webRequest) {
        ExceptionResponse response = new ExceptionResponse();
        response.setDateTime(LocalDateTime.now());
        response.setMessage("Not found");
        ResponseEntity<Object> entity = new ResponseEntity(response, HttpStatus.NOT_FOUND);
        return entity;
    }
}
