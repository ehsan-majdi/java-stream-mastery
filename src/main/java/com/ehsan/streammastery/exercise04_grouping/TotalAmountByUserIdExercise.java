package com.ehsan.streammastery.exercise04_grouping;

import com.ehsan.streammastery.data.SampleData;
import com.ehsan.streammastery.model.Order;
import com.ehsan.streammastery.model.User;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class TotalAmountByUserIdExercise {

    public static void main(String[] args) {
        List<User> users = SampleData.users();
        List<Order> orders = SampleData.orders();

        Map<Long, Long> totalAmountByUserId = orders.stream()
                .filter(order ->
                        order != null
                                && order.getAmount() != null
                                && order.getUserId() != null
                                && Objects.equals(order.getStatus(), "SUCCESS")
                )
                .filter(order -> users.stream()
                        .anyMatch(user ->
                                user != null
                                        && Boolean.TRUE.equals(user.getActive())
                                        && Objects.equals(order.getUserId(), user.getId())
                        )
                )
                .collect(Collectors.groupingBy(
                        Order::getUserId,
                        Collectors.summingLong(Order::getAmount)
                ));

        totalAmountByUserId.forEach((userId, totalAmount) ->
                System.out.println(userId + " -> " + totalAmount)
        );
    }
}
