package com.tsola2002.recommendationservice.service;

import com.tsola2002.recommendationservice.entity.Recommendation;
import com.tsola2002.recommendationservice.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {
    @Autowired
    private RecommendationRepository recommendationRepository;

    //this method get all book recommendation by productId
    public List<Recommendation> getRecommendationByProductId(int productId) {
        return recommendationRepository.findByProductId(productId);
    }
    //this method gets all recommendation
    public List<Recommendation> getAllRecommendations(){return recommendationRepository.findAll();}

    //update a recommendendation by id
    public Recommendation updateRecommendationDetails(Long id, Recommendation recommendationDetails){
        return recommendationRepository.findById(id).map(recommendation -> {
            recommendation.setBookAuthor(recommendationDetails.getBookAuthor());
            recommendation.setContent(recommendationDetails.getContent());
            recommendation.setRate(recommendationDetails.getRate());

            return recommendationRepository.save(recommendation);
        }).orElseThrow(() -> new RuntimeException("recommendation not found with id " + id));

    }
    // add a book recommendation
    public Recommendation addRecomendation(Recommendation recommendation) {
        return recommendationRepository.save(recommendation);
    }

    //delete all recommendation for a particular product
    public Recommendation deleteByProductId(int productId) {
        recommendationRepository.deleteAll(recommendationRepository.findByProductId(productId));
        return null;
    }

}
