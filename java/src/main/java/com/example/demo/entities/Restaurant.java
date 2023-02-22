package com.example.demo.entities;

import java.util.List;
import java.util.Objects;

public class Restaurant {
    
    private Long id;
    private String name;
    private Long totalReviewsCount;
    private Double overallRating;
    private List<Reviews> reviewsList;
    private int totalRaters;
    // private ReviewsService reviewsService;

    public Restaurant(Long id, String name, Long totalReviewsCount, Double overallRating, List<Reviews> reviewsList) {
        this.id = id;
        this.name = name;
        this.totalReviewsCount = totalReviewsCount;
        this.overallRating = overallRating;
        this.reviewsList = reviewsList;
        this.totalRaters = 0;
    }

    public Restaurant(Long id, String name, Long totalReviewsCount, Double overallRating) {
        this.id = id;
        this.name = name;
        this.totalReviewsCount = totalReviewsCount;
        this.overallRating = overallRating;
    }

    public Restaurant(Long id, String name, Long totalReviewsCount) {
        this.id = id;
        this.name = name;
        this.totalReviewsCount = totalReviewsCount;
    }

    public Restaurant(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // public Restaurant(Long id, String name, ReviewsService reviewsService) {
    //     this.id = id;
    //     this.name = name;
    //     this.reviewsService = reviewsService;
    // }

    // public Double getTotalRating() {
    //     return reviewsService.getTotalRating(id);
    // }
    
    public void setTotalRaters(int totalRaters) {
        this.totalRaters = totalRaters;
    }

    public int getTotalRaters() {
        return totalRaters;
    }

    public void add(Reviews reviews) {
        this.reviewsList.add(reviews);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTotalReviewsCount() {
        return totalReviewsCount;
    }

    public void setTotalReviewsCount(Long totalReviewsCount) {
        this.totalReviewsCount = totalReviewsCount;
    }

    public Double getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(Double overallRating) {
        this.overallRating = overallRating;
    }

    public List<Reviews> getReviews() {
        return reviewsList;
    }

    public void setReviews(List<Reviews> reviewsList) {
        this.reviewsList = reviewsList;
    }

    public Double getAverageRating() {
        Double totalRatings = 0D;
        for (Reviews review : reviewsList) {
            totalRatings += review.getRating();
        }
        return totalRatings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Restaurant that = (Restaurant) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(totalReviewsCount, that.totalReviewsCount))
            return false;
        if (!Objects.equals(overallRating, that.overallRating))
            return false;
        return Objects.equals(reviewsList, that.reviewsList);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (totalReviewsCount != null ? totalReviewsCount.hashCode() : 0);
        result = 31 * result + (overallRating != null ? overallRating.hashCode() : 0);
        result = 31 * result + (reviewsList != null ? reviewsList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Restaurant [" +
                "id=" + id +
                ']';
    }

    // public void modifyRating(Double rating) {
    //     this.overallRating = rating;
    // }
}
