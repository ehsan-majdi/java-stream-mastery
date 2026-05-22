package com.ehsan.streammastery.exercise01_filter;

import com.ehsan.streammastery.data.SampleData;
import com.ehsan.streammastery.model.User;

import java.util.List;

public class ActiveUsersExercise {

    public static void main(String[] args) {
        List<User> users = SampleData.users();

        List<User> activeUsers = users.stream()
                .filter(user ->
                        user != null
                                && Boolean.TRUE.equals(user.getActive())
                )
                .toList();

        activeUsers.forEach(user ->
                System.out.println(user.getName())
        );
    }
}
