package com.olukunle.java_payment_task.exceptions;

public class EncryptionException extends RuntimeException {
    private final String code;

    public EncryptionException(String code, String message){
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
