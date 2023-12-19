package com.olukunle.java_payment_task.repository;

import com.olukunle.java_payment_task.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Optional<Transaction> findTransactionByRequestId(String requestId);
    Page<Transaction> findAllByUserId(Long userId, PageRequest pageRequest);
}
