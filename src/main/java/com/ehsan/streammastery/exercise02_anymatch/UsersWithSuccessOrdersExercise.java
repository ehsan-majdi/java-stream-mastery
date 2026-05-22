package com.ehsan.streammastery.exercise02_anymatch;


import com.ehsan.streammastery.data.SampleData;
import com.ehsan.streammastery.model.Order;
import com.ehsan.streammastery.model.User;

import java.util.List;
import java.util.Objects;

public class UsersWithSuccessOrdersExercise {

    public static void main(String[] args) {
        List<User> users = SampleData.users();
        List<Order> orders = SampleData.orders();

        List<User> filteredUsers = users.stream()
                .filter(user ->
                        user != null
                                && Boolean.TRUE.equals(user.getActive())
                )
                .filter(user -> orders.stream()
                        .anyMatch(order ->
                                order != null
                                        && Objects.equals(user.getId(), order.getUserId())
                                        && Objects.equals(order.getStatus(), "SUCCESS")
                        )
                )
                .toList();

        filteredUsers.forEach(user ->
                System.out.println(user.getName())
        );
    }
}
