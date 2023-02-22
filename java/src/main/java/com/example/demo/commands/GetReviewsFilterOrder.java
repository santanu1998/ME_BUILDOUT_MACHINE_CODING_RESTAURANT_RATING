package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Reviews;
import com.example.demo.services.ReviewsService;

public class GetReviewsFilterOrder implements ICommand {

    private final ReviewsService reviewsService;

    public GetReviewsFilterOrder(ReviewsService reviewsService) {
        this.reviewsService = reviewsService;
    }

    @Override
    public void invoke(List<String> tokens) {
        Long restaurantId = Long.parseLong(tokens.get(1));
        int low = Integer.parseInt(tokens.get(2));
        int high = Integer.parseInt(tokens.get(3));
        String order = tokens.get(4);
        List<Reviews> reviews = reviewsService.getReviewsFilterOrder(restaurantId, low, high, order);
        System.out.println(reviews);
    }
    
}
