package com.microservice.order_service.entity;

public class TransactionResponse {
    private Order order;
    private String TransactionId;
    private String status;

    public TransactionResponse() {
    }

    public TransactionResponse(Order order, String transactionId, String status) {
        this.order = order;
        TransactionId = transactionId;
        this.status = status;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public String getTransactionId() {
        return TransactionId;
    }

    public void setTransactionId(String transactionId) {
        TransactionId = transactionId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
