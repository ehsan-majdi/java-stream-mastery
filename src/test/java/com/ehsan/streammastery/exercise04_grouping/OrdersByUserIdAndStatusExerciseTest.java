package com.ehsan.streammastery.exercise04_grouping;

import com.ehsan.streammastery.data.SampleData;
import com.ehsan.streammastery.model.Order;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class OrdersByUserIdAndStatusExerciseTest {

    @Test
    void groupsOrdersByUserIdThenStatus() {
        Map<Long, Map<String, Long>> ordersByUserIdAndStatus =
                OrdersByUserIdAndStatusExercise.countByUserIdAndStatus(SampleData.orders());

        assertThat(ordersByUserIdAndStatus.get(1L))
                .containsEntry("SUCCESS", 2L)
                .containsEntry("FAILED", 1L);
    }

    @Test
    void countsOrdersWithNullAmount() {
        Map<Long, Map<String, Long>> ordersByUserIdAndStatus =
                OrdersByUserIdAndStatusExercise.countByUserIdAndStatus(SampleData.orders());

        assertThat(ordersByUserIdAndStatus.get(4L))
                .containsEntry("SUCCESS", 2L);
    }

    @Test
    void excludesOrdersWithoutUserId() {
        Map<Long, Map<String, Long>> ordersByUserIdAndStatus =
                OrdersByUserIdAndStatusExercise.countByUserIdAndStatus(SampleData.orders());

        assertThat(ordersByUserIdAndStatus)
                .doesNotContainKey(null);
    }

    @Test
    void excludesOrdersWithoutStatus() {
        List<Order> orders = List.of(
                new Order(1L, "SUCCESS", 100000L),
                new Order(1L, " ", 200000L)
        );

        Map<Long, Map<String, Long>> ordersByUserIdAndStatus =
                OrdersByUserIdAndStatusExercise.countByUserIdAndStatus(orders);

        assertThat(ordersByUserIdAndStatus.get(1L))
                .containsOnly(Map.entry("SUCCESS", 1L));
    }
}
