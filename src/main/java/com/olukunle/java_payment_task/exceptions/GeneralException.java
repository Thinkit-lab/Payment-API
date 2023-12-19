package com.olukunle.java_payment_task.exceptions;

public class GeneralException extends RuntimeException {
    private final String code;

    public GeneralException(String code, String message){
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
