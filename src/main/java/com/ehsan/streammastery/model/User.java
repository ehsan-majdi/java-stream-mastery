package com.ehsan.streammastery.model;

import java.util.List;

public class User {

    private Long id;
    private String name;
    private Boolean active;
    private List<Card> cards;

    public User(Long id, String name, Boolean active) {
        this.id = id;
        this.name = name;
        this.active = active;
    }

    public User(Long id, String name, Boolean active, List<Card> cards) {
        this.id = id;
        this.name = name;
        this.active = active;
        this.cards = cards;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getActive() {
        return active;
    }

    public List<Card> getCards() {
        return cards;
    }
}