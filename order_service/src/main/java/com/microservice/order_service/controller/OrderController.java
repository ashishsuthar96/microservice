package com.microservice.order_service.controller;

import com.microservice.order_service.entity.Order;
import com.microservice.order_service.entity.TransactionRequest;
import com.microservice.order_service.entity.TransactionResponse;
import com.microservice.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    private OrderService service;

    @Autowired
    public OrderController(OrderService service) {
        this.service = service;
    }
    @PostMapping("/bookOrder")
    public TransactionResponse create(@RequestBody TransactionRequest request){
        return service.create(request);
    }

}
