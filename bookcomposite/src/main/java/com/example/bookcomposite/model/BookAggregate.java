package com.example.bookcomposite.model;

import java.util.List;

public class BookAggregate {
    private Integer id;
    private String name;
    private String weight;
    private List<Recommendation> recommendations;
    private List<Review> reviews;

    public BookAggregate(Integer id,
                         String name,
                         String weight,
                         List<Recommendation> recommendations,
                         List<Review> reviews) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.recommendations = recommendations;
        this.reviews = reviews;
    }

    public Integer getId() { return id; }
    public String getName() { return name; }
    public String getWeight() { return weight; }
    public List<Recommendation> getRecommendations() { return recommendations; }
    public List<Review> getReviews() { return reviews; }
}
