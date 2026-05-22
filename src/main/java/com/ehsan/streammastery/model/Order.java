package com.ehsan.streammastery.model;

public class Order {
    private Long userId;
    private String status;
    private Long amount;

    public Order(Long userId, String status, Long amount) {
        this.userId = userId;
        this.status = status;
        this.amount = amount;
    }

    public Long getUserId() {
        return userId;
    }

    public String getStatus() {
        return status;
    }

    public Long getAmount() {
        return amount;
    }
}