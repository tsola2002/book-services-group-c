package com.tsola2002.recommendationservice.repository;

import com.tsola2002.recommendationservice.entity.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecommendationRepository extends JpaRepository<Recommendation , Long> {
    List<Recommendation> findByProductId(int productId);

}
