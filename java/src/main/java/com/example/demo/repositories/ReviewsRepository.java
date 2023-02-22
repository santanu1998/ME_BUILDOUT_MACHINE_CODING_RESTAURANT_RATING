package com.example.demo.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.example.demo.entities.Reviews;

public class ReviewsRepository implements IReviewsRepository {

    private final Map<Long, Reviews> reviewsMap;
    private Long autoIncrement = 1L;

    public ReviewsRepository(){
        reviewsMap = new HashMap<Long, Reviews>();
    }

    @Override
    public Reviews save(Reviews reviews) {
        if (reviews.getId() == null) {
            Reviews myReviews = new Reviews(autoIncrement, reviews.getRating());
            reviewsMap.put(myReviews.getId(), myReviews);
            ++autoIncrement;
            return myReviews;
        }
        reviewsMap.put(reviews.getId(), reviews);
        return reviews;
    }

    @Override
    public boolean existsById(Long id) {
        return reviewsMap.containsKey(id);
    }

    @Override
    public Optional<Reviews> findById(Long id) {
        return Optional.ofNullable(reviewsMap.get(id));
    }

    @Override
    public List<Reviews> findAll() {
        return reviewsMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        reviewsMap.remove(id);
    }

    @Override
    public long count() {
        return reviewsMap.size();
    }

    @Override
    public void delete(Reviews reviews) {
        reviewsMap.remove(reviews);
    }
    
}
