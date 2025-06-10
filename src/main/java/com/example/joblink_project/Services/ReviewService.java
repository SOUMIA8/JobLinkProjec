package com.example.joblink_project.Services;

import com.example.joblink_project.Models.Review;

import java.util.List;

public interface ReviewService {
    Review createReview(Long candidateId, Long offerId, Integer rating, String comment);
    Review updateReview(Long reviewId, Integer newRating, String newComment);
    void deleteReview(Long reviewId);
    Review getReviewById(Long id);
    List<Review> getReviewsByCandidate(Long candidateId);
    List<Review> getReviewsByOffer(Long offerId);
}
