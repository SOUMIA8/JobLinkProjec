package com.example.joblink_project.Services;

import com.example.joblink_project.Models.Application;
import com.example.joblink_project.Models.Offer;
import com.example.joblink_project.Models.Recruiter;

import java.util.List;

public interface RecruiterService {
    Recruiter getRecruiterById(Long id);
    List<Recruiter> getAllRecruiters();
    Recruiter createRecruiter(Recruiter recruiter);
    Recruiter updateRecruiter(Long id, Recruiter recruiterDetails);
    void deleteRecruiter(Long id);
    String voirStatistiquesOffres(Long recruiterId);
    String recevoirSuggestionsAmeliorationOffres(Long recruiterId);
    List<Offer> getOffersByRecruiter(Long recruiterId);
    Offer getOfferById(Long offerId);
    List<Application> getApplicationsByOfferId(Long offerId);

    // Add more methods like voirCandidatureRecue if needed
}
