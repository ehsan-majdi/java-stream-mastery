package com.ehsan.streammastery.model;

public class UserOrderSummary {
    private Long userId;
    private String name;
    private Long totalSuccessAmount;

    public UserOrderSummary(Long userId, String name, Long totalSuccessAmount) {
        this.userId = userId;
        this.name = name;
        this.totalSuccessAmount = totalSuccessAmount;
    }

    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public Long getTotalSuccessAmount() {
        return totalSuccessAmount;
    }
}
