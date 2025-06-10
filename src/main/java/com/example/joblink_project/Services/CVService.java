package com.example.joblink_project.Services;

import com.example.joblink_project.Models.CV;

import java.util.List;

public interface CVService {
    CV getById(Long id);
    List<CV> getAll();
    List<CV> getByCandidateId(Long candidateId);
    CV create(CV cv);
    CV update(Long id, CV updatedCV);
    void delete(Long id);
}
