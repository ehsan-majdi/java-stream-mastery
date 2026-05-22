package com.ehsan.streammastery.exercise03_map;

import com.ehsan.streammastery.data.SampleData;
import com.ehsan.streammastery.model.User;

import java.util.List;
import java.util.Objects;

public class UserNamesExercise {

    public static void main(String[] args) {
        List<User> users = SampleData.users();

        List<String> names = users.stream()
                .filter(Objects::nonNull)
                .map(User::getName)
                .filter(Objects::nonNull)
                .toList();

        names.forEach(System.out::println);
    }
}