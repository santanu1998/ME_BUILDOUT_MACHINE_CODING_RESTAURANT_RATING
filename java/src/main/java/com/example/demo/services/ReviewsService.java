package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import com.example.demo.entities.Restaurant;
import com.example.demo.entities.Reviews;
import com.example.demo.repositories.IReviewsRepository;

public class ReviewsService {
    private final IReviewsRepository reviewsRepository;

    public ReviewsService(IReviewsRepository reviewsRepository) {
        this.reviewsRepository = reviewsRepository;
    }
    // public void addRating(Double rating, Long userId, Long restId, String dishes, String description) {
    //     User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User with id: " + userId + "not found"));
    //     Restaurant restaurant = restaurantRepository.findById(restId).orElseThrow(() -> new RuntimeException("Restaurant with id: " + restId + "not found"));
    //     String uniqueId = userId.toString() + "_" + restId.toString();
    //     Reviews reviews = new Reviews(userId, restId, uniqueId, rating, dishes, description);
    //     Reviews review = reviewsRepository.save(reviews);
    //     restaurant.modifyRating(rating);
    //     user.addReview(review.getUniqueId());
    //     userRepository.modify(user);
    // }

    private List<Reviews> reviewsList = new ArrayList<>();

    public String addRating(Double rating, Long userId, Long restaurantId) {
        Reviews reviews = new Reviews(Long.valueOf(reviewsList.size() + 1), rating, userId, restaurantId);
        // Reviews r = null;
        for (int i = 0; i < reviewsList.size(); i++) {
            if (reviewsList.get(i).getUserId() == userId && reviewsList.get(i).getRestaurantId() == restaurantId) {
                reviewsList.set(i, reviews);
                Reviews restultantReviews = reviewsRepository.save(reviews);
                // return reviews;
                return "Review [id=" + reviews.getId() + "] added successfully for Restaurant [id=" + restaurantId + "] by User [id=" + userId + "]!";
            }
        }
        reviewsList.add(reviews);
        Reviews restultantReviews = reviewsRepository.save(reviews);
        // return reviews;
        return "Review [id=" + restultantReviews.getId() + "] added successfully for Restaurant [id=" + restaurantId + "] by User [id=" + userId + "]!";
        // System.out.println("Review [id=" + r.getId() + "] added successfully for Restaurant [id=" + restaurantId + "] by User [id=" + userId + "]!");
    }

    private void addRatingForRestaurant(Restaurant restaurant, Reviews review, String userName) {
        Double totalRating = restaurant.getOverallRating();
        int totalRaters = restaurant.getTotalRaters();
        // if(indexAndRating.size() != 0) {
        //     restaurant.setTotalRating(totalRating - indexAndRating.get(1));
        //     restaurant.setTotalRating(totalRaters - 1);
        //     restaurant.getRestaurantReviewList().remove(indexAndRating.get(0).intValue());
        //     totalRating -= indexAndRating.get(1);
        //     totalRaters -= 1;
        // }
        // restaurant.getRestaurantReviewList().add(review);
        restaurant.setOverallRating(totalRating + review.getRating());
        restaurant.setTotalRaters(totalRaters + 1);
    }

    public Double getTotalRating(Long restaurantId) {
        List<Double> restaurantRatings = new ArrayList<>();
        for (int i = 0; i < reviewsList.size(); i++) {
            restaurantRatings.set(0, reviewsList.get(restaurantId.intValue()).getRating());
        }
        Double totalRating = 0D;
        for (Double rating : restaurantRatings) {
          totalRating += rating;
        }
        return (Double) totalRating / restaurantRatings.size();
    }

    public Reviews addReview(Double rating, Long userId, Long restaurantId, String dishNames, String description) {
        List<Reviews> reviews = new ArrayList<>();
        Reviews review = reviewsRepository.findById(restaurantId).orElseThrow(()-> new RuntimeException("Cannot find restaurant. Restaurant id- "+restaurantId+" is not present!"));
        reviews.add(review);

        Reviews r = new Reviews(Long.valueOf(reviews.size() + 1), rating, userId, restaurantId, dishNames, description);
        for (int i = 0; i < reviewsList.size(); i++) {
            if (reviews.get(i).getUserId() == userId && reviews.get(i).getRestaurantId() == restaurantId) {
                reviews.set(i, r);
                Reviews restultantReviews = reviewsRepository.save(r);
                return restultantReviews;
            }
        }
        reviews.add(r);
        Reviews restultantReviews = reviewsRepository.save(r);
        return restultantReviews;
        // Reviews reviews = new Reviews(Long.valueOf(reviewsList.size() + 1), rating, userId, restaurantId, dishNames, description);
        // for (int i = 0; i < reviewsList.size(); i++) {
        //     if (reviewsList.get(i).getUserId() == userId && reviewsList.get(i).getRestaurantId() == restaurantId) {
        //         reviewsList.set(i, reviews);
        //         return reviews;
        //     }
        // }
        // reviewsList.add(reviews);
        // return reviews;
    }

    public List<Reviews> getReviews(Long restaurantId, String order) {
        // List<Reviews> filteredReviews = new ArrayList<>();
        // for (Reviews reviews : reviewsList) {
        //     if (reviews.getRestaurantId() == restaurantId) {
        //         filteredReviews.add(reviews);
        //     }
        // }
        // if (order.equals("RATING_ASC")) {
        //     filteredReviews.sort((r1, r2) -> r1.getRating().intValue() - r2.getRating().intValue());
        // } 
        // else {
        //     filteredReviews.sort((r1, r2) -> r2.getRating().intValue() - r1.getRating().intValue());
        // }
        // return filteredReviews;

        List<Reviews> filteredReviews = new ArrayList<>();
        for (Reviews review : reviewsList) {
            if (review.getRestaurantId() == restaurantId) {
                filteredReviews.add(review);
            }
        }
        if (order.equals("RATING_ASC")) {
            filteredReviews.sort((r1, r2) -> r1.getRating().intValue() - r2.getRating().intValue());
        } 
        else {
            filteredReviews.sort((r1, r2) -> r2.getRating().intValue() - r1.getRating().intValue());
        }
        return filteredReviews;
    }

    /* 
    public List<Reviews> getReviewsFilterOrder(Long restaurantId, Long low, Long high, String order) {
        List<Reviews> filteredReviews = new ArrayList<>();
        for (Reviews review : reviewsList) {
            if (review.getRestaurantId() == restaurantId && review.getRating() >= low && review.getRating() <= high) {
                filteredReviews.add(review);
            }
        }
        if (order.equals("RATING_DESC")) {
            filteredReviews.sort((r1, r2) -> r2.getRating().intValue() - r1.getRating().intValue());
        } 
        else {
            filteredReviews.sort((r1, r2) -> r1.getRating().intValue() - r2.getRating().intValue());
        }
        return filteredReviews;
    }
    */

    public List<Reviews> getReviewsFilterOrder(Long restaurantId, Integer minRating, Integer maxRating, String orderBy) {
        List<Reviews> filteredReviews = new ArrayList<>();
        for (Reviews review : reviewsList) {
            if (review.getRestaurantId().equals(restaurantId)
                    && review.getRating() >= minRating
                    && review.getRating() <= maxRating) {
                filteredReviews.add(review);
            }
        }
        // if (orderBy.equals("RATING_ASC")) {
        //     filteredReviews.sort((r1, r2) -> (int) (r1.getRating() - r2.getRating()));
        // } else if (orderBy.equals("RATING_DESC")) {
        //     filteredReviews.sort((r1, r2) -> (int) (r2.getRating() - r1.getRating()));
        // }

        if (orderBy.equals("RATING_ASC")) {
            filteredReviews.sort((review1, review2) -> review1.getRating().compareTo(review2.getRating()));
        } else if (orderBy.equals("RATING_DESC")) {
            filteredReviews.sort((review1, review2) -> review2.getRating().compareTo(review1.getRating()));
        }
        return filteredReviews;
    }
    
}
