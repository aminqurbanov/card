package com.example.cardbalance.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ExceptionConstants {
    CARD_NOT_FOUND("CARD_NOT_FOUND","Card not found"),
    UNEXPECTED_EXCEPTION("UNEXPECTED_EXCEPTION","Unexpected exception accure"),;

    private String code;
    private String message;
}