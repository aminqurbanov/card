package com.example.cardbalance.exception;


import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException{

    String code;

    public NotFoundException(String message, String code) {
        super(message);
        this.code = code;
    }
}
