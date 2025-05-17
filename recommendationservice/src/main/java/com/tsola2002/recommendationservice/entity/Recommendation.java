package com.tsola2002.recommendationservice.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Recommendation {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long recommendationId;
    @Column
    private long productId;

    @Column
    private String  bookAuthor;

    @Column
    private int rate;

    @Column
    private String content;
    public Recommendation() {
        // Default constructor needed by JPA
    }


    public Recommendation(long productId, String bookAuthor, int rate, String content) {
        this.productId = productId;
        this.bookAuthor = bookAuthor;
        this.rate = rate;
        this.content = content;
    }

    public long getProductId() {
        return productId;
    }

    public long getRecommendationId() {
        return recommendationId;
    }
    public int getRate() {
        return rate;
    }
    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getContent() {
        return content;
    }



    public void setProductId(long productId) {
        this.productId = productId;
    }


    public void setContent(String content) {
        this.content = content;
    }
    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
