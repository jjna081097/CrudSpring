package com.Alfaro.CrudCars.exception;

import java.time.LocalDateTime;

public class ExceptionResponse {
    private String message;
    private LocalDateTime dateTime;

    public ExceptionResponse() {
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
