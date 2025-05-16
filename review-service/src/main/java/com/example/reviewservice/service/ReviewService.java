package com.example.reviewservice.service;

import com.example.reviewservice.model.Review;
import com.example.reviewservice.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository repository;

    public ReviewService(ReviewRepository repository) {
        this.repository = repository;
    }

    public Review createReview(Review review) {
        return repository.save(review);
    }

    public List<Review> getReviewsByBookId(String bookId) {
        return repository.findByBookId(bookId);
    }

    public void deleteReview(String id) {
        repository.deleteById(id);
    }
}