package com.olukunle.java_payment_task.advice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.olukunle.java_payment_task.exceptions.BadRequestException;
import com.olukunle.java_payment_task.exceptions.EncryptionException;
import com.olukunle.java_payment_task.exceptions.GeneralException;
import com.olukunle.java_payment_task.exceptions.NotFoundException;
import com.olukunle.java_payment_task.payload.BaseResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

import static com.olukunle.java_payment_task.constants.ResponseStatus.*;


@RestControllerAdvice()
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ApiAdvice {

    @ExceptionHandler({BadRequestException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse<?> handleBadRequestException(BadRequestException e) {
        BaseResponse<?> response = new BaseResponse<>();
        response.setStatus(FAILED.getStatus());
        response.setCode(GENERAL_ERROR.getCode());
        response.setMessage(e.getMessage());
        return response;
    }

    @ExceptionHandler({NotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public BaseResponse<?> handleNotFoundException(NotFoundException e) {
        BaseResponse<?> response = new BaseResponse<>();
        response.setStatus(FAILED.getStatus());
        response.setCode(e.getCode());
        response.setMessage(e.getMessage());
        return response;
    }

    @ExceptionHandler({MissingRequestHeaderException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse<?> handleMissingRequestHeaderException(MissingRequestHeaderException e) {
        BaseResponse<?> response = new BaseResponse<>();
        response.setStatus(FAILED.getStatus());
        response.setCode(INVALID_REQUEST.getCode());
        response.setMessage(e.getMessage());
        return response;
    }

    @ExceptionHandler({JsonProcessingException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BaseResponse<?> handleJsonProcessingException(JsonProcessingException e) {
        BaseResponse<?> response = new BaseResponse<>();
        response.setStatus(FAILED.getStatus());
        response.setCode(GENERAL_ERROR.getCode());
        response.setMessage(e.getMessage());
        return response;
    }

    @ExceptionHandler({GeneralException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<?> handleGeneralException(GeneralException e) {
        return new ResponseEntity<>(new BaseResponse<>(
                FAILED.getStatus(),
                GENERAL_ERROR.getCode(),
                e.getMessage(),
                null),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({EncryptionException.class})
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public BaseResponse<?> handleEncryptionException(EncryptionException e) {
        BaseResponse<?> response = new BaseResponse<>();
        response.setStatus(FAILED.getStatus());
        response.setCode(GENERAL_ERROR.getCode());
        response.setMessage(e.getMessage());
        return response;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = { MethodArgumentNotValidException.class })
    protected ResponseEntity<?> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(new BaseResponse<>(
                INVALID_FIELDS_PROVIDED.getStatus(),
                INVALID_FIELDS_PROVIDED.getCode(),
                FAILED.getStatus(),
                errors),
                HttpStatus.BAD_REQUEST);
    }

}
