package com.ehsan.streammastery.model;


public class WalletAccount {
    private String groupCode;
    private Long balance;

    public WalletAccount(String groupCode, Long balance) {
        this.groupCode = groupCode;
        this.balance = balance;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public Long getBalance() {
        return balance;
    }
}
