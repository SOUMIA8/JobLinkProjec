package com.example.joblink_project.ServicesImplementation;

import com.example.joblink_project.Enum.ApplicationStatus;
import com.example.joblink_project.Models.Application;
import com.example.joblink_project.Models.Offer;
import com.example.joblink_project.Models.Candidate;
import com.example.joblink_project.Repositories.ApplicationRepository;
import com.example.joblink_project.Repositories.OfferRepository;
import com.example.joblink_project.Repositories.CandidateRepository;
import com.example.joblink_project.Services.ApplicationService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final OfferRepository offerRepository;
    private final CandidateRepository candidateRepository;

    @Autowired
    public ApplicationServiceImpl(ApplicationRepository applicationRepository,OfferRepository offerRepository,CandidateRepository candidateRepository){
        this.applicationRepository = applicationRepository;
        this.offerRepository = offerRepository;
        this.candidateRepository = candidateRepository;
    }

    @Override
    public Application applyToOffer(Long offerId, Long candidateId) {
        Offer offer = offerRepository.findById(offerId)
                .orElseThrow(() -> new RuntimeException("Offer not found"));
        Candidate candidate = candidateRepository.findById(candidateId)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        Application application = new Application();
        application.setOffer(offer);
        application.setCandidate(candidate);
        application.setStatus(ApplicationStatus.PENDING);

        return applicationRepository.save(application);
    }

    @Override
    public List<Application> getApplicationsByCandidate(Long candidateId) {
        return applicationRepository.findByCandidateId(candidateId);
    }


    @Override
    public List<Application> getApplicationsByOffer(Long offerId) {
        return applicationRepository.findByOfferId(offerId);
    }

    @Override
    public Application getApplicationById(Long applicationId) {
        return applicationRepository.findById(applicationId)
                .orElseThrow(() -> new RuntimeException("Application not found"));
    }

    @Override
    public Application saveApplication(Application application) {
        return applicationRepository.save(application);
    }

    @Override
    public void deleteApplication(Long applicationId) {
        applicationRepository.deleteById(applicationId);
    }

    @Override
    public void accepterCandidature(Long applicationId) {
        var application = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new RuntimeException("Candidature not found"));
        application.setStatus(ApplicationStatus.ACCEPTED);
        applicationRepository.save(application);
    }

    @Override
    public void rejeterCandidature(Long applicationId) {
        var application = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new RuntimeException("Candidature not found"));
        application.setStatus(ApplicationStatus.REJECTED);
        applicationRepository.save(application);
    }

    @Override
    public void contacterCandidatViaPlateforme(Long applicationId, String message) {
        // Simulate message sending, e.g., create a Notification
    }

    @Override
    public void poserQuestionSurCandidature(Long applicationId, String question) {
        // Simulate question sending or storing
    }
}
