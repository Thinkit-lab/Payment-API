package com.olukunle.java_payment_task.exceptions;

public class NotFoundException extends RuntimeException {
     private final String  code;
     
    public NotFoundException(String code, String message){
        super(message);
        this.code = code;
    }

    public String getCode(){
        return this.code;
    }

}
