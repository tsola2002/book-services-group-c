package com.example.bookcomposite.controller;

import com.example.bookcomposite.integration.BookCompositeIntegration;
import com.example.bookcomposite.model.Book;
import com.example.bookcomposite.model.BookAggregate;
import com.example.bookcomposite.model.Recommendation;
import com.example.bookcomposite.model.Review;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/book-aggregates")
public class BookCompositeController {

    private final BookCompositeIntegration integration;

    public BookCompositeController(BookCompositeIntegration integration) {
        this.integration = integration;
    }

    @GetMapping
    public List<BookAggregate> getBookAggregates() {
        return integration.getBooks().stream()
                .map(this::toAggregate)
                .collect(Collectors.toList());
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookAggregate> getBookAggregate(@PathVariable int bookId) {
        Book book = integration.getBookById(bookId);
        if (book == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(toAggregate(book));
    }

    private BookAggregate toAggregate(Book book) {
        List<Recommendation> recs = integration.getRecommendationsForBook(book.getId());
        List<Review> reviews = integration.getReviewsForBook(book.getId());
        return new BookAggregate(
                book.getId(),
                book.getName(),
                book.getWeight(),
                recs,
                reviews
        );
    }
}
