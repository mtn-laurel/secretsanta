package com.example.secretsanta.dto;

public class CreateGroupRequest {

    private String name;
    private int budget;

    public CreateGroupRequest() {
        // required for JSON deserialization
    }

    public String getName() {
        return name;
    }

    public int getBudget() {
        return budget;
    }
}