package com.olukunle.java_payment_task.constants;

import lombok.Getter;

@Getter
public enum ResponseStatus {

    SUCCESS("Success", "MwI00"),
    FAILED("Failed", "MwF00"),
    INVALID_REQUEST("Invalid request", "MwE00"),
    GENERAL_ERROR("An error occurred", "MwG00"),
    ENCRYPTION_ERROR("Encryption error", "MwG01"),
    INVALID_FIELDS_PROVIDED("Invalid fields provided", "MwE01"),
    ;

    private final String status;
    private final String code;

    ResponseStatus(String status, String code) {
        this.status = status;
        this.code = code;
    }

}
