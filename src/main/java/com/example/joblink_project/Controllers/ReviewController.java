package com.example.joblink_project.Controllers;

import com.example.joblink_project.Models.Review;
import com.example.joblink_project.Services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/candidate/{candidateId}/offer/{offerId}")
    public ResponseEntity<Review> createReview(
            @PathVariable Long candidateId,
            @PathVariable Long offerId,
            @RequestParam Integer rating,
            @RequestParam String comment
    ) {
        Review review = reviewService.createReview(candidateId, offerId, rating, comment);
        return ResponseEntity.ok(review);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<Review> updateReview(
            @PathVariable Long reviewId,
            @RequestParam Integer rating,
            @RequestParam String comment
    ) {
        Review updated = reviewService.updateReview(reviewId, rating, comment);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long reviewId) {
        reviewService.deleteReview(reviewId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long reviewId) {
        return ResponseEntity.ok(reviewService.getReviewById(reviewId));
    }

    @GetMapping("/candidate/{candidateId}")
    public ResponseEntity<List<Review>> getReviewsByCandidate(@PathVariable Long candidateId) {
        return ResponseEntity.ok(reviewService.getReviewsByCandidate(candidateId));
    }

    @GetMapping("/offer/{offerId}")
    public ResponseEntity<List<Review>> getReviewsByOffer(@PathVariable Long offerId) {
        return ResponseEntity.ok(reviewService.getReviewsByOffer(offerId));
    }
}
