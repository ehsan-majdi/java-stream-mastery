package com.ehsan.streammastery.model;

public class Card {
    private String cardNumber;
    private Long balance;
    private Boolean enabled;

    public Card(String cardNumber, Long balance, Boolean enabled) {
        this.cardNumber = cardNumber;
        this.balance = balance;
        this.enabled = enabled;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Long getBalance() {
        return balance;
    }

    public Boolean getEnabled() {
        return enabled;
    }
}
