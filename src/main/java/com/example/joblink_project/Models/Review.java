package com.example.joblink_project.Models;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "Reviews",
        uniqueConstraints = @UniqueConstraint(
                name = "unique_review_per_candidate_offer",
                columnNames = {"candidate_id", "offer_id"}))
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer rating;

    @Lob
    private String comment;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "offer_id", nullable = false)
    private Offer offer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id", nullable = false)
    private Candidate candidate;

    // Méthode utilitaire pour créer une review
    /*public static Review createReview(Integer rating, String comment, Offer offer, Candidate candidate) {
        return Review.builder()
                .rating(rating)
                .comment(comment)
                .offer(offer)
                .candidate(candidate)
                .build();
    }*/
}