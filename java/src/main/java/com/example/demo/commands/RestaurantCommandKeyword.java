package com.example.demo.commands;

public enum RestaurantCommandKeyword {
    
    // Register Command Keywords
    
    REGISTER_RESTAURANT_COMMAND("REGISTER_RESTAURANT"),
    REGISTER_USER_COMMAND("REGISTER_USER"),
    ADD_REVIEW_COMMAND("ADD_REVIEW"),
    ADD_RATING_COMMAND("ADD_RATING"),
    GET_REVIEWS_COMMAND("GET_REVIEWS"),
    DESCRIBE_RESTAURANT_COMMAND("DESCRIBE_RESTAURANT"),
    LIST_RESTAURANT_COMMAND("LIST_RESTAURANT"),
    GET_REVIEWS_FILTER_ORDER_COMMAND("GET_REVIEWS_FILTER_ORDER");

    private final String name;
    private RestaurantCommandKeyword(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
