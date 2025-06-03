package com.example.bookcomposite.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Review {
    private String id;

    @JsonProperty("bookId")
    private String bookId;

    private String reviewer;
    private String comment;
    private String createdAt;

    public Review() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getBookId() { return bookId; }
    public void setBookId(String bookId) { this.bookId = bookId; }

    public String getReviewer() { return reviewer; }
    public void setReviewer(String reviewer) { this.reviewer = reviewer; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
}
