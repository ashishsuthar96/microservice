package com.microservice.payment_service.controller;

import com.microservice.payment_service.entity.Payment;
import com.microservice.payment_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private PaymentService service;
    @Autowired
    public PaymentController(PaymentService service) {
        this.service = service;
    }
    @PostMapping("/pay")
    public Payment create(@RequestBody Payment payment){
        return service.create(payment);
    }
    @GetMapping("/{orderId}")
    public Payment findTranscationByOrderId(@PathVariable int orderId){
        return service.findTranscationByOrderId(orderId);
    }
}
