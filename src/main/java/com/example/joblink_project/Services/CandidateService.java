package com.example.joblink_project.Services;

import com.example.joblink_project.Models.Candidate;

import java.util.List;
import java.util.Optional;

public interface CandidateService {
    List<Candidate> getAllCandidates();
    Optional<Candidate> getCandidateById(Long id);
    Candidate createCandidate(Candidate candidate);
    Candidate updateCandidate(Long id, Candidate candidate);
    void deleteCandidate(Long id);
}
