package com.example.reviewservice.controller;

import com.example.reviewservice.model.Review;
import com.example.reviewservice.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")  // Replace with your allowed origin
@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService service;

    public ReviewController(ReviewService service) {
        this.service = service;
    }

    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return service.createReview(review);
    }

    @GetMapping("/book/{bookId}")
    public List<Review> getReviewsByBookId(@PathVariable String bookId) {
        return service.getReviewsByBookId(bookId);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable String id) {
        service.deleteReview(id);
    }
}
