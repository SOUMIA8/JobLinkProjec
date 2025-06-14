package com.example.joblink_project.Repositories;

import com.example.joblink_project.Models.Candidate;
import com.example.joblink_project.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

}
