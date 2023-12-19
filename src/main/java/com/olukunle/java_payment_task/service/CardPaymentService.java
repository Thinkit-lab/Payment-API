package com.olukunle.java_payment_task.service;

import com.olukunle.java_payment_task.constants.StringValues;
import com.olukunle.java_payment_task.entity.Transaction;
import com.olukunle.java_payment_task.payload.request.CardPaymentModel;
import com.olukunle.java_payment_task.payload.response.PaymentResponse;
import com.olukunle.java_payment_task.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardPaymentService implements PaymentService<CardPaymentModel> {

    private final TransactionRepository transactionRepository;
    @Override
    public PaymentResponse makePayment(CardPaymentModel request) {
        // Make call to a payment gateway
        String transRef = UUID.randomUUID().toString();
        Transaction transaction = new Transaction();
        BeanUtils.copyProperties(request, transaction);
        transaction.setTransactionRef(transRef);
        transactionRepository.save(transaction);
        return PaymentResponse.builder()
                .paymentType(transaction.getPaymentType())
                .amount(transaction.getAmount())
                .transactionRef(transRef)
                .build();
    }

    @Override
    public String getPaymentMethod() {
        return StringValues.CARD_PAYMENT_METHOD;
    }
}
