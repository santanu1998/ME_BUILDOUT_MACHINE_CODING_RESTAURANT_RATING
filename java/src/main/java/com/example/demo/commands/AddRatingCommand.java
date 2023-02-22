package com.example.demo.commands;

import java.util.List;
import com.example.demo.services.ReviewsService;

public class AddRatingCommand implements ICommand {

    private final ReviewsService reviewsService;

    public AddRatingCommand(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }

    @Override
    public void invoke(List<String> tokens) {
        Double rating = Double.parseDouble(tokens.get(1));
        Long userId = Long.parseLong(tokens.get(2));
        Long restaurantId = Long.parseLong(tokens.get(3));
        // Reviews reviews = reviewsService.addRating(rating, userId, restaurantId);
        String reviews = reviewsService.addRating(rating, userId, restaurantId);
        System.out.println(reviews);
    }
    
}
