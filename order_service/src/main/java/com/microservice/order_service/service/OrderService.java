package com.microservice.order_service.service;

import com.microservice.order_service.dao.OrderDao;
import com.microservice.order_service.entity.Order;
import com.microservice.order_service.entity.Payment;
import com.microservice.order_service.entity.TransactionRequest;
import com.microservice.order_service.entity.TransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class OrderService {
    private OrderDao dao;
    private RestTemplate template;
    @Autowired
    public OrderService(OrderDao dao, RestTemplate template) {
        this.dao = dao;
        this.template=template;
    }

    public TransactionResponse create(TransactionRequest request) {
        Order order= new Order();
        order.setAmount(request.getAmount());
        order.setName(request.getName());
        order.setQty(request.getQty());
        Order orderResponse = dao.save(order);

        Payment payment= new Payment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getAmount());

        Payment paymentResponse= template.postForObject("http://PAYMENT-SERVICE/payment/pay", payment, Payment.class);

        String message="";
        message= paymentResponse.getStatus().equals("success") ? "Success ! Your is Places !!"
                :"Failed ! Please try Again later !!";
        return new TransactionResponse(order, paymentResponse.getTransactionId(), message);
    }
}
