package com.ehsan.streammastery.model;

public class Merchant {
    private String id;
    private String groupCode;

    public Merchant(String id, String groupCode) {
        this.id = id;
        this.groupCode = groupCode;
    }

    public String getId() {
        return id;
    }

    public String getGroupCode() {
        return groupCode;
    }
}