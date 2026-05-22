package com.ehsan.streammastery.exercise01_filter;


import com.ehsan.streammastery.data.SampleData;
import com.ehsan.streammastery.model.Order;

import java.util.List;

public class ValidAmountOrdersExercise {

    public static void main(String[] args) {
        List<Order> orders = SampleData.orders();

        List<Order> validAmountOrders = orders.stream()
                .filter(order ->
                        order != null
                                && order.getAmount() != null
                )
                .toList();

        validAmountOrders.forEach(order ->
                System.out.println(order.getStatus() + " -> " + order.getAmount())
        );
    }
}