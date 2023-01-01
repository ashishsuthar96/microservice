package com.microservice.payment_service.dao;

import com.microservice.payment_service.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDao extends JpaRepository<Payment, Integer> {
    Payment findByOrderId(int orderId);
}
