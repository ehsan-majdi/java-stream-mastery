package com.ehsan.streammastery.data;

import com.ehsan.streammastery.model.*;

import java.util.List;

public class SampleData {

    public static List<User> users() {
        return List.of(
                new User(1L, "Ali", true),
                new User(2L, "Reza", false),
                new User(3L, "Sara", true),
                new User(4L, "Mina", true),
                new User(5L, "Omid", null)
        );
    }

    public static List<Order> orders() {
        return List.of(
                new Order(1L, "SUCCESS", 500000L),
                new Order(1L, "FAILED", 200000L),
                new Order(1L, "SUCCESS", 300000L),
                new Order(2L, "SUCCESS", 100000L),
                new Order(3L, "PENDING", 300000L),
                new Order(4L, "SUCCESS", 700000L),
                new Order(4L, "SUCCESS", null),
                new Order(null, "SUCCESS", 900000L)
        );

    }

    public static List<WalletAccount> accounts() {
        return List.of(
                new WalletAccount("00", 500000L),
                new WalletAccount("2490", 300000L),
                new WalletAccount("500", 100000L),
                new WalletAccount(null, 900000L),
                new WalletAccount("", 700000L)
        );
    }

    public static List<Merchant> merchants() {
        return List.of(
                new Merchant("100", "00"),
                new Merchant("200", "00"),
                new Merchant("300", "2490"),
                new Merchant("400", "700")
        );
    }

    public static List<User> usersWithCards() {
        return List.of(
                new User(1L, "Ali", true, List.of(
                        new Card("1111", 500000L, true),
                        new Card("2222", 100000L, false)
                )),
                new User(2L, "Reza", false, List.of(
                        new Card("3333", 900000L, true)
                )),
                new User(3L, "Sara", true, List.of(
                        new Card("4444", 300000L, true),
                        new Card("5555", null, true)
                )),
                new User(4L, "Mina", true, null),
                new User(5L, "Omid", null, List.of(
                        new Card("6666", 700000L, true)
                ))
        );
    }

    public static List<WalletAccount> walletAccounts() {
        return List.of(
                new WalletAccount("00", 500000L),
                new WalletAccount("2490", 300000L),
                new WalletAccount("500", 100000L),
                new WalletAccount(null, 900000L),
                new WalletAccount("", 700000L)
        );
    }
}
