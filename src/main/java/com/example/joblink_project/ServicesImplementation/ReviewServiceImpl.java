package com.example.joblink_project.ServicesImplementation;

import com.example.joblink_project.Models.Candidate;
import com.example.joblink_project.Models.Offer;
import com.example.joblink_project.Models.Review;
import com.example.joblink_project.Repositories.CandidateRepository;
import com.example.joblink_project.Repositories.OfferRepository;
import com.example.joblink_project.Repositories.ReviewRepository;
import com.example.joblink_project.Services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private OfferRepository offerRepository;

    @Override
    public Review createReview(Long candidateId, Long offerId, Integer rating, String comment) {
        Candidate candidate = candidateRepository.findById(candidateId)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));
        Offer offer = offerRepository.findById(offerId)
                .orElseThrow(() -> new RuntimeException("Offer not found"));

        // Prevent duplicate review
        reviewRepository.findByCandidateIdAndOfferId(candidateId, offerId)
                .ifPresent(r -> { throw new RuntimeException("Review already exists for this offer by this candidate"); });

        Review review = new Review();
        review.setCandidate(candidate);
        review.setOffer(offer);
        review.setRating(rating);
        review.setComment(comment);

        return reviewRepository.save(review);
    }

    @Override
    public Review updateReview(Long reviewId, Integer newRating, String newComment) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new RuntimeException("Review not found"));

        review.setRating(newRating);
        review.setComment(newComment);

        return reviewRepository.save(review);
    }

    @Override
    public void deleteReview(Long reviewId) {
        if (!reviewRepository.existsById(reviewId)) {
            throw new RuntimeException("Review not found");
        }
        reviewRepository.deleteById(reviewId);
    }

    @Override
    public Review getReviewById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));
    }

    @Override
    public List<Review> getReviewsByCandidate(Long candidateId) {
        return reviewRepository.findByCandidateId(candidateId);
    }

    @Override
    public List<Review> getReviewsByOffer(Long offerId) {
        return reviewRepository.findByOfferId(offerId);
    }
}
