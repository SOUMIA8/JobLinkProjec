package com.example.joblink_project.Services;

import com.example.joblink_project.Models.Application;

import java.util.List;

public interface ApplicationService {
    Application applyToOffer(Long offerId, Long candidateId);
    List<Application> getApplicationsByCandidate(Long candidateId);
    List<Application> getApplicationsByOffer(Long offerId);
    Application getApplicationById(Long applicationId);
    void deleteApplication(Long applicationId);
    Application saveApplication(Application application);
    void accepterCandidature(Long candidatureId);
    void rejeterCandidature(Long candidatureId);
    void contacterCandidatViaPlateforme(Long candidatureId, String message);
    void poserQuestionSurCandidature(Long candidatureId, String question);
}
