package com.example.bookcomposite.model;

public class Recommendation {
    private Integer recommendationId;
    private Integer productId;
    private String bookAuthor;
    private Integer rate;
    private String content;

    public Recommendation() {}

    public Integer getRecommendationId() {
        return recommendationId;
    }
    public void setRecommendationId(Integer recommendationId) {
        this.recommendationId = recommendationId;
    }

    public Integer getProductId() {
        return productId;
    }
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }
    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public Integer getRate() {
        return rate;
    }
    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
