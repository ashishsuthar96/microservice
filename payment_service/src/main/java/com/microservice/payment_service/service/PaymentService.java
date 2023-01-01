package com.microservice.payment_service.service;

import com.microservice.payment_service.dao.PaymentDao;
import com.microservice.payment_service.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {
    private PaymentDao dao;
    @Autowired
    public PaymentService(PaymentDao dao) {
        this.dao = dao;
    }

    public Payment create(Payment payment) {
        payment.setTransactionId(UUID.randomUUID().toString());
        payment.setStatus(status());
        return this.dao.save(payment);
    }
    private String status(){
        return new Random().nextBoolean() ? "success" : "failed";
    }


    public Payment findTranscationByOrderId(int orderId) {
        return dao.findByOrderId(orderId);
    }
}
