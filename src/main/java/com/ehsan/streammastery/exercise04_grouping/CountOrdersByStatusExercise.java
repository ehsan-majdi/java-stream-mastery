package com.ehsan.streammastery.exercise04_grouping;

import com.ehsan.streammastery.data.SampleData;
import com.ehsan.streammastery.model.Order;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountOrdersByStatusExercise {

    public static void main(String[] args) {
        List<Order> orders = SampleData.orders();

        Map<String, Long> countByStatus = orders.stream()
                .filter(order ->
                        order != null
                                && order.getStatus() != null
                                && !order.getStatus().isBlank()
                )
                .collect(Collectors.groupingBy(
                        Order::getStatus,
                        Collectors.counting()
                ));

        countByStatus.forEach((status, count) ->
                System.out.println(status + " -> " + count)
        );
    }
}
