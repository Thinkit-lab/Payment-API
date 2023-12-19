package com.olukunle.java_payment_task.controller;

import com.olukunle.java_payment_task.payload.BaseResponse;
import com.olukunle.java_payment_task.payload.request.CardPaymentModel;
import com.olukunle.java_payment_task.payload.request.PaymentRequest;
import com.olukunle.java_payment_task.payload.response.PaymentResponse;
import com.olukunle.java_payment_task.service.PaymentServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/v1/payment")
public class PaymentController {

    private final PaymentServiceImpl paymentServiceImpl;

    @Operation(summary = "Process payment", description = "Process payment")
    @PostMapping(value = "/process_payment", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse<PaymentResponse>> processPayment(
            HttpServletRequest request, @RequestBody PaymentRequest paymentRequest) {
        return ResponseEntity.ok(paymentServiceImpl.processPayment(request, paymentRequest));
    }

    @Operation(summary = "Get user's payment history", description = "Get user's payment history")
    @GetMapping(value = "/get_payment/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse<List<PaymentResponse>>> getPayment(
            HttpServletRequest request, @RequestParam(value = "pageNumber", defaultValue = "1") int pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize, @PathVariable Long userId) {
        return ResponseEntity.ok(paymentServiceImpl.getPayment(request, pageNumber, pageSize, userId));
    }
}
