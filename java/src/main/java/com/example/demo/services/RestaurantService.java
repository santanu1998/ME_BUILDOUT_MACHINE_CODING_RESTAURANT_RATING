package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.example.demo.entities.Restaurant;
import com.example.demo.repositories.IRestaurantRepository;
import com.example.demo.repositories.IReviewsRepository;

public class RestaurantService {
    private final IRestaurantRepository restaurantRepository;
    private final IReviewsRepository reviewsRepository;

    public RestaurantService(IRestaurantRepository restaurantRepository, IReviewsRepository reviewsRepository) {
        this.restaurantRepository = restaurantRepository;
        this.reviewsRepository = reviewsRepository;
    }

    private List<Restaurant> restaurants = new ArrayList<>();
    
    public Restaurant registerRestaurant(String name) {
        Restaurant restaurant = new Restaurant(Long.valueOf(restaurants.size() + 1), name);
        restaurants.add(restaurant);
        Restaurant r = restaurantRepository.save(restaurant);
        return r;
    }

    public List<Restaurant> listRestaurants() {
        return restaurants;
    }

    /* 
    public void describeRestaurant(Long restaurantId) {
        Restaurant r = null;
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getId() == restaurantId) {
                r = restaurant;
            }
        }
        System.out.println("Restaurant [id=" + r.getId() + ", name=" + r.getName() + ", rating=" + r.getOverallRating() + "]");
    }
    */

    /* 
    public void describeRestaurant(Long restaurantId) {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getId() == restaurantId) {
                //System.out.println("Restaurant [id=" + restaurant.getId() + ", name=" + restaurant.getName() + ", rating=" + restaurantRepository.findAll().stream().filter(t->t.getId().equals(restaurantId)).findFirst().get() + "]");
                System.out.println("Restaurant [id=" + restaurant.getId() + ", name=" + restaurant.getName() + ", rating=" + reviewsRepository.findAll().stream().filter(t->t.getId().equals(restaurantId)).findFirst().get().getRating() + "]");
                break;
            }
        }
    }
    */

    public void describeRestaurant(Long restaurantId) {
        Restaurant restaurant = null;
        for (Restaurant res : restaurants) {
            if (res.getId() == restaurantId) {
                restaurant = res;
                break;
            }
        }
        if (restaurant == null) {
            System.out.println("Restaurant with id " + restaurantId + " not found.");
            return;
        }
    
        List<Double> ratings = reviewsRepository.findAll().stream().filter(review -> review.getRestaurantId().equals(restaurantId)).map(review -> review.getRating()).collect(Collectors.toList());
        if (ratings.size() == 0) {
            System.out.println("Restaurant [id=" + restaurant.getId() + ", name=" + restaurant.getName() + ", rating=No ratings yet]");
        } else {
            double avgRating = ratings.stream().mapToDouble(val -> val).average().orElse(0.0);
            System.out.println("Restaurant [id=" + restaurant.getId() + ", name=" + restaurant.getName() + ", rating=" + avgRating + "]");
        }
    }
    

    /* 
    public void describeRestaurant(Long restaurantId) {
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getId() == restaurantId) {
                Double totalRatings = 0D;
                Double ratingsCount = 0D;
                for (Reviews review : restaurant.getReviews()) {
                    totalRatings += review.getRating();
                    ratingsCount++;
                }
                if (ratingsCount > 0) {
                    restaurant.setOverallRating((Double) totalRatings / ratingsCount);
                }
                System.out.println("Restaurant [id=" + restaurant.getId() + ", name=" + restaurant.getName() + ", rating=" + restaurant.getAverageRating() + "]");
                //break;
            }
        }
        // return null;
    }
    */

    /* 
    public void describeRestaurant(Long restaurantId) {
        Restaurant restaurant = null;
        for (Restaurant res : restaurants) {
            if (res.getId() == restaurantId) {
                restaurant = res;
                break;
            }
        }
        if (restaurant == null) {
            System.out.println("Restaurant with id " + restaurantId + " not found.");
            return;
        }

        Double rating = 0D;
        Integer count = 0;
        for (Reviews review : restaurant.getReviews()) {
            rating += review.getRating();
            count++;
        }
        if (count > 0) {
            rating /= count;
        }

        //System.out.println("Restaurant [id=" + restaurant.getId() + ", name=" + restaurant.getName() + ", rating=" + restaurant.getAverageRating() + "]");

        System.out.println("Restaurant [id=" + restaurant.getId() + ", name=" + restaurant.getName() + ", rating=" + rating + "]");
    }
    */

    /* 
    public static List<Restaurant> getRestaurants() {
        for (Restaurant restaurant : restaurants) {
            double avgRating = ReviewService.getAverageRating(restaurant.getId());
            restaurant.setRating(avgRating);
        }
        return restaurants;
    }
    */
}
