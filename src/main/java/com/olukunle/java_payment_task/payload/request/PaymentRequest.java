package com.olukunle.java_payment_task.payload.request;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest extends BasePaymentModel{
    @Nullable
    private String cardNumber;
    @Nullable
    private String cardHolderName;
    @Nullable
    private String expirationDate;
    @Nullable
    private String cvv;
}
