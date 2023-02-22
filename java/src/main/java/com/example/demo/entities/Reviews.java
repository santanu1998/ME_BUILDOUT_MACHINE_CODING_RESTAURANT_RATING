package com.example.demo.entities;

import java.util.Objects;

public class Reviews {

    private Long id;
    private Long userId;
    private Long restaurantId;
    private Double rating;
    private String dishes;
    private String description;

    public Reviews(Long id, Long userId, Long restaurantId, Double rating, String dishes, String description) {
        this.id = id;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.rating = rating;
        this.dishes = dishes;
        this.description = description;
    }

    public Reviews(Long id, Double rating, Long userId, Long restaurantId, String dishes, String description) {
        this.id = userId;
        this.rating = rating;
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.dishes = dishes;
        this.description = description;
    }

    public Reviews(Long id, Double rating, String description, String dishes, Long userId) {
        this.id = id;
        this.rating = rating;
        this.description = description;
        this.dishes = dishes;
        this.userId = userId;
    }

    public Reviews(Long id, Double rating, Long userId, Long restaurantId) {
        this.id = id;
        this.rating = rating;
        this.userId = userId;
        this.restaurantId = restaurantId;
    }

    public Reviews(Long id, Double rating, String description) {
        this.id = id;
        this.rating = rating;
        this.description = description;
    }

    public Reviews(Long id, Double rating) {
        this.id = id;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDishes() {
        return dishes;
    }

    public void setDishes(String dishes) {
        this.dishes = dishes;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    // public Double getAverageRating() {
    //     Double totalRatings = 0D;
    //     for (Reviews review : reviews) {
    //         totalRatings += review.getRating();
    //     }
    //     return totalRatings;
    // }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reviews reviews = (Reviews) o;

        if (!Objects.equals(id, reviews.id)) return false;
        if (!Objects.equals(userId, reviews.userId)) return false;
        if (!Objects.equals(restaurantId, reviews.restaurantId))
            return false;
        if (!Objects.equals(rating, reviews.rating)) return false;
        if (!Objects.equals(dishes, reviews.dishes)) return false;
        return Objects.equals(description, reviews.description);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (restaurantId != null ? restaurantId.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (dishes != null ? dishes.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Review [id=" + id + "]";
        // return "Review [id=" + id + "] added successfully for Restaurant [id=" + restaurantId + "] by User [id=" + userId + "]!";
    }

        

}
