package com.example.joblink_project.Repositories;

import com.example.joblink_project.Models.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter, Long> {
    // You can add custom queries here if needed
}
