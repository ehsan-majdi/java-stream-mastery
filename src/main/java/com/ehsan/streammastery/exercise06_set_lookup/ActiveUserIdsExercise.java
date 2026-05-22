package com.ehsan.streammastery.exercise06_set_lookup;

import com.ehsan.streammastery.data.SampleData;
import com.ehsan.streammastery.model.User;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ActiveUserIdsExercise {

    public static void main(String[] args) {
        List<User> users = SampleData.users();

        Set<Long> activeUserIds = users.stream()
                .filter(user ->
                        user != null
                                && user.getId() != null
                                && Boolean.TRUE.equals(user.getActive())
                )
                .map(User::getId)
                .collect(Collectors.toSet());

        activeUserIds.forEach(System.out::println);
    }
}