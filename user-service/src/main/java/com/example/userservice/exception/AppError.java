package com.example.userservice.exception;

import lombok.Data;

import java.util.Date;

@Data
public class AppError {
    private Object status;
    private String message;
    private Date timestamp;

    public AppError(Object status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = new Date();
    }
}
