package com.ehsan.streammastery.exercise01_filter;

import com.ehsan.streammastery.data.SampleData;
import com.ehsan.streammastery.model.Order;

import java.util.List;
import java.util.Objects;

public class SuccessOrdersExercise {

    public static void main(String[] args) {
        List<Order> orders = SampleData.orders();

        List<Order> successOrders = orders.stream()
                .filter(order ->
                        order != null
                                && Objects.equals(order.getStatus(), "SUCCESS")
                )
                .toList();

        successOrders.forEach(order ->
                System.out.println(
                        "userId: " + order.getUserId()
                                + " | status: " + order.getStatus()
                                + " | amount: " + order.getAmount()
                )
        );
    }
}
