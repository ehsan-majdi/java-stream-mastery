package com.ehsan.streammastery.exercise04_grouping;


import com.ehsan.streammastery.data.SampleData;
import com.ehsan.streammastery.model.Order;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TotalAmountByStatusExercise {

    public static void main(String[] args) {
        List<Order> orders = SampleData.orders();

        Map<String, Long> totalAmountByStatus = orders.stream()
                .filter(order ->
                        order != null
                                && order.getAmount() != null
                                && order.getStatus() != null
                                && !order.getStatus().isBlank()
                )
                .collect(Collectors.groupingBy(
                        Order::getStatus,
                        Collectors.summingLong(Order::getAmount)
                ));

        totalAmountByStatus.forEach((status, totalAmount) ->
                System.out.println(status + " -> " + totalAmount)
        );
    }
}