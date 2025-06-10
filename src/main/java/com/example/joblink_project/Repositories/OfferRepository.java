package com.example.joblink_project.Repositories;

import com.example.joblink_project.Models.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
    List<Offer> findByRecruiterId(Long recruiterId);
    List<Offer> findByIsApproved(Boolean isApproved);
    long countByRecruiterId(Long recruiterId);
}
