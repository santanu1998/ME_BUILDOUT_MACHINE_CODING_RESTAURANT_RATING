package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Reviews;
import com.example.demo.services.ReviewsService;

public class GetReviewsCommand implements ICommand {

    private final ReviewsService reviewsService;

    public GetReviewsCommand(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }

    @Override
    public void invoke(List<String> tokens) {
        Long restaurantId = Long.parseLong(tokens.get(1));
        String order = tokens.get(2);
        List<Reviews> reviews = reviewsService.getReviews(restaurantId, order);
        System.out.println(reviews);
    }
    
}
