package com.tsola2002.recommendationservice.controller;

import com.tsola2002.recommendationservice.entity.Recommendation;
import com.tsola2002.recommendationservice.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/bookrecommendations")
// @CrossOrigin(origins = "http://localhost:7003")
@CrossOrigin(origins = "*")
public class RecommendationController {



    @Autowired
    private RecommendationService recommendationService;

    @GetMapping
    public List<Recommendation> getAllRecommendations(){return recommendationService.getAllRecommendations();}

    @GetMapping("/{productId}") //API That gets all  recommendations based on productId
    public List<Recommendation> getByProductId(@PathVariable int productId) {
        return recommendationService.getRecommendationByProductId(productId);
    }


    // add recommendation
    @PostMapping
    public Recommendation add(@RequestBody Recommendation recommendation) {
        return  recommendationService.addRecomendation(recommendation);

    }
    @PutMapping("/{id}")
    public Recommendation updateRecommendationDetails(@PathVariable Long id, @RequestBody Recommendation recommendationDetails ){
        return recommendationService.updateRecommendationDetails(id, recommendationDetails);


    }

    @DeleteMapping("/{productId}")
    public Recommendation delete(@PathVariable int productId){
        return recommendationService.deleteByProductId(productId);
    }


}
