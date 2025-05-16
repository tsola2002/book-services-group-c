package com.example.reviewservice.repository;

import com.example.reviewservice.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReviewRepository extends MongoRepository<Review, String> {
    List<Review> findByBookId(String bookId);
}