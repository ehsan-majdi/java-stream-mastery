package com.ehsan.streammastery.exercise04_grouping;

import com.ehsan.streammastery.data.SampleData;
import com.ehsan.streammastery.model.Order;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrdersByUserIdAndStatusExercise {

    public static void main(String[] args) {
        Map<Long, Map<String, Long>> ordersByUserIdAndStatus =
                countByUserIdAndStatus(SampleData.orders());

        ordersByUserIdAndStatus.forEach((userId, countByStatus) ->
                countByStatus.forEach((status, count) ->
                        System.out.println(userId + " -> " + status + " -> " + count)
                )
        );
    }

    public static Map<Long, Map<String, Long>> countByUserIdAndStatus(List<Order> orders) {
        return orders.stream()
                .filter(order ->
                        order != null
                                && order.getUserId() != null
                                && order.getStatus() != null
                                && !order.getStatus().isBlank()
                )
                .collect(Collectors.groupingBy(
                        Order::getUserId,
                        Collectors.groupingBy(
                                Order::getStatus,
                                Collectors.counting()
                        )
                ));
    }
}
