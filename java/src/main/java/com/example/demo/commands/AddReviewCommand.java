package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Reviews;
import com.example.demo.services.ReviewsService;

public class AddReviewCommand implements ICommand {

    private final ReviewsService reviewsService;

    public AddReviewCommand(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }

    @Override
    public void invoke(List<String> tokens) {
        Double rating = Double.parseDouble(tokens.get(1));
        Long userId = Long.parseLong(tokens.get(2));
        Long restaurantId = Long.parseLong(tokens.get(3));
        String dishes = tokens.get(4);
        String description = tokens.get(5);
        Reviews reviews = reviewsService.addReview(rating, userId, restaurantId, dishes, description);
        System.out.println(reviews);
    }
    
}
