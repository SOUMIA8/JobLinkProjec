package com.example.joblink_project.ServicesImplementation;

import com.example.joblink_project.Models.Application;
import com.example.joblink_project.Models.Offer;
import com.example.joblink_project.Models.Recruiter;
import com.example.joblink_project.Repositories.ApplicationRepository;
import com.example.joblink_project.Repositories.OfferRepository;
import com.example.joblink_project.Repositories.RecruiterRepository;
import com.example.joblink_project.Services.RecruiterService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.joblink_project.Enum.ApplicationStatus;

import java.util.List;

@Service
@Transactional
public class RecruiterServiceImpl implements RecruiterService {


    private final RecruiterRepository recruiterRepository;
    private final OfferRepository offerRepository;
    private final ApplicationRepository applicationRepository;

    @Autowired
    public RecruiterServiceImpl(RecruiterRepository recruiterRepository,
                                OfferRepository offerRepository,
                                ApplicationRepository applicationRepository) {
        this.recruiterRepository = recruiterRepository;
        this.offerRepository = offerRepository;
        this.applicationRepository = applicationRepository;
    }
    @Override
    public Recruiter getRecruiterById(Long id) {
        return recruiterRepository.findById(id).orElseThrow(() -> new RuntimeException("Recruiter not found with id " + id));
    }


    @Override
    public List<Recruiter> getAllRecruiters() {
        return recruiterRepository.findAll();
    }

    @Override
    public Recruiter createRecruiter(Recruiter recruiter) {
        return recruiterRepository.save(recruiter);
    }

    @Override
    public Recruiter updateRecruiter(Long id, Recruiter recruiterDetails) {
        Recruiter existingRecruiter = getRecruiterById(id);
        existingRecruiter.setCompanyName(recruiterDetails.getCompanyName());
        existingRecruiter.setCompanyWebsite(recruiterDetails.getCompanyWebsite());
        existingRecruiter.setCompanySize(recruiterDetails.getCompanySize());
        return recruiterRepository.save(existingRecruiter);
    }

    @Override
    public void deleteRecruiter(Long id) {
        Recruiter recruiter = getRecruiterById(id);
        recruiterRepository.delete(recruiter);
    }


    @Override
    public String voirStatistiquesOffres(Long recruiterId) {
        // Simulate statistics generation
        return "Nombre d'offres: " + offerRepository.countByRecruiterId(recruiterId);
    }

    @Override
    public String recevoirSuggestionsAmeliorationOffres(Long recruiterId) {
        return "Suggestions: Ajouter plus de détails, améliorer le titre, etc.";
    }

    @Override
    public List<Offer> getOffersByRecruiter(Long recruiterId) {
        return offerRepository.findByRecruiterId(recruiterId);
    }

    @Override
    public Offer getOfferById(Long offerId) {
        return offerRepository.findById(offerId)
                .orElseThrow(() -> new RuntimeException("Offer not found"));
    }

    @Override
    public List<Application> getApplicationsByOfferId(Long offerId) {
        Offer offer = offerRepository.findById(offerId)
                .orElseThrow(() -> new RuntimeException("Offre non trouvée"));
        return applicationRepository.findByOffer(offer);
    }
}
