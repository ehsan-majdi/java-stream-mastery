package com.ehsan.streammastery.exercise03_map;


import com.ehsan.streammastery.data.SampleData;
import com.ehsan.streammastery.model.Order;
import com.ehsan.streammastery.model.User;
import com.ehsan.streammastery.model.UserOrderSummary;

import java.util.List;
import java.util.Objects;

public class UserOrderSummaryExercise {

    public static void main(String[] args) {
        List<User> users = SampleData.users();
        List<Order> orders = SampleData.orders();

        List<UserOrderSummary> summaries = users.stream()
                .filter(user ->
                        user != null
                                && Boolean.TRUE.equals(user.getActive())
                )
                .map(user -> {
                    long totalSuccessAmount = orders.stream()
                            .filter(order ->
                                    order != null
                                            && order.getAmount() != null
                                            && Objects.equals(order.getUserId(), user.getId())
                                            && Objects.equals(order.getStatus(), "SUCCESS")
                            )
                            .mapToLong(Order::getAmount)
                            .sum();

                    return new UserOrderSummary(
                            user.getId(),
                            user.getName(),
                            totalSuccessAmount
                    );
                })
                .filter(summary ->
                        summary.getTotalSuccessAmount() > 0
                )
                .toList();

        summaries.forEach(summary ->
                System.out.println(
                        summary.getName() + " -> " + summary.getTotalSuccessAmount()
                )
        );
    }
}
