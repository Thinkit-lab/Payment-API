package com.olukunle.java_payment_task.constants;

public interface StringValues {
    String AUTHORIZATION_KEY = "Authorization";
    String LOGGER_STRING_GET = "Request url -> {} response -> {}";
    String LOGGER_STRING_POST = "Request url -> {} payload -> {} response -> {}";
    String USER_RECORD_SAVED = "User record saved successfully";
    String AUTHENTICATION_SUCCESSFUL = "Successfully authenticated user";
    String NO_USER_RECORD_FOUND = "No user record found with the query parameter";
    String REQUEST_COMPLETED = "Request completed successfully";
    String RECORD_FOUND = "Record found";
    String NO_RECORD_FOUND = "No record found";
    String CARD_PAYMENT_METHOD = "card";
    String VALIDATION_SUCCESS = "Validation successful";
    String INVALID_PAYMENT_TYPE = "Invalid payment type";
    String PAYMENT_PROCESS_SUCCESSFUL = "Payment processing completed";
    String DUPLICATE_REQUEST_ID = "Duplicate Request Id";
    String UNSUPPORTED_PAYMENT_METHOD = "Unsupported payment method";
    String UNSUPPORTED_DEVICE = "Unsupported device";
    String MOBILE_CHANNEL = "mobile";
    String WEB_CHANNEL = "web";
}
