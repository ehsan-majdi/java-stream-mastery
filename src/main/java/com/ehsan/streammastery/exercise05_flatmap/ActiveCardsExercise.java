package com.ehsan.streammastery.exercise05_flatmap;


import com.ehsan.streammastery.data.SampleData;
import com.ehsan.streammastery.model.Card;
import com.ehsan.streammastery.model.User;

import java.util.List;

public class ActiveCardsExercise {

    public static void main(String[] args) {
        List<User> users = SampleData.usersWithCards();

        List<Card> filteredCards = users.stream()
                .filter(user ->
                        user != null
                                && Boolean.TRUE.equals(user.getActive())
                                && user.getCards() != null
                )
                .flatMap(user -> user.getCards().stream())
                .filter(card ->
                        card != null
                                && Boolean.TRUE.equals(card.getEnabled())
                                && card.getBalance() != null
                                && card.getBalance() > 200000
                )
                .toList();

        filteredCards.forEach(card ->
                System.out.println(card.getCardNumber() + " -> " + card.getBalance())
        );
    }
}
