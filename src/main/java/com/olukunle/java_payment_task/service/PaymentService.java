package com.olukunle.java_payment_task.service;

import com.olukunle.java_payment_task.payload.request.PaymentModel;
import com.olukunle.java_payment_task.payload.response.PaymentResponse;

public interface PaymentService<T extends PaymentModel> {
    PaymentResponse makePayment(T request);
    String getPaymentMethod();
}
