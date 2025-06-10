package com.example.joblink_project.ServicesImplementation;

import com.example.joblink_project.Models.Candidate;
import com.example.joblink_project.Repositories.CandidateRepository;
import com.example.joblink_project.Services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    @Override
    public Optional<Candidate> getCandidateById(Long id) {
        return candidateRepository.findById(id);
    }

    @Override
    public Candidate createCandidate(Candidate candidate) {
        candidate.setId(null); // Force creation, not update
        return candidateRepository.save(candidate);
    }

    @Override
    public Candidate updateCandidate(Long id, Candidate updatedCandidate) {
        return candidateRepository.findById(id).map(candidate -> {
            candidate.setProfession(updatedCandidate.getProfession());
            candidate.setSkills(updatedCandidate.getSkills());
            candidate.setExperience(updatedCandidate.getExperience());
            // Update other fields if needed
            return candidateRepository.save(candidate);
        }).orElseThrow(() -> new RuntimeException("Candidate not found with id " + id));
    }

    @Override
    public void deleteCandidate(Long id) {
        candidateRepository.deleteById(id);
    }
}
