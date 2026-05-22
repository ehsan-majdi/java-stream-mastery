package com.ehsan.streammastery.exercise06_set_lookup;

import com.ehsan.streammastery.data.SampleData;
import com.ehsan.streammastery.model.Order;
import com.ehsan.streammastery.model.User;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class ActiveUserSuccessOrdersExercise {

    public static void main(String[] args) {
        List<User> users = SampleData.users();
        List<Order> orders = SampleData.orders();

        Set<Long> activeUserIds = users.stream()
                .filter(user ->
                        user != null
                                && user.getId() != null
                                && Boolean.TRUE.equals(user.getActive())
                )
                .map(User::getId)
                .collect(Collectors.toSet());

        List<Order> activeSuccessOrders = orders.stream()
                .filter(order ->
                        order != null
                                && activeUserIds.contains(order.getUserId())
                                && Objects.equals(order.getStatus(), "SUCCESS")
                )
                .toList();

        activeSuccessOrders.forEach(order ->
                System.out.println(
                        "userId: " + order.getUserId()
                                + " | status: " + order.getStatus()
                                + " | amount: " + order.getAmount()
                )
        );
    }
}