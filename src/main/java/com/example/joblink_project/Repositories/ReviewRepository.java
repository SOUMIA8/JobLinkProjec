package com.example.joblink_project.Repositories;

import com.example.joblink_project.Models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByCandidateId(Long candidateId);
    List<Review> findByOfferId(Long offerId);
    Optional<Review> findByCandidateIdAndOfferId(Long candidateId, Long offerId);
}
