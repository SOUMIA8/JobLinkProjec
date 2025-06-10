package com.example.joblink_project.ServicesImplementation;

import com.example.joblink_project.Models.Offer;
import com.example.joblink_project.Models.Recruiter;
import com.example.joblink_project.Repositories.ApplicationRepository;
import com.example.joblink_project.Repositories.OfferRepository;
import com.example.joblink_project.Repositories.RecruiterRepository;
import com.example.joblink_project.Services.OfferService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;
    private final RecruiterRepository recruiterRepository;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository,
                            RecruiterRepository recruiterRepository
    ) {
        this.offerRepository = offerRepository;
        this.recruiterRepository = recruiterRepository;
    }

    @Override
    public Offer createOffer(Offer offer) {
        return offerRepository.save(offer);
    }

    @Override
    public Offer updateOffer(Long id, Offer offer) {
        Optional<Offer> existing = offerRepository.findById(id);
        if (existing.isPresent()) {
            offer.setId(id);
            return offerRepository.save(offer);
        }
        return null;
    }

    @Override
    public void deleteOffer(Long id) {
        offerRepository.deleteById(id);
    }
    @Override
    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }

    @Override
    public Offer getOfferById(Long id) {
        return offerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Offer not found"));
    }

    @Override
    public List<Offer> getOffersByRecruiter(Long recruiterId) {
        return offerRepository.findByRecruiterId(recruiterId);
    }

    @Override
    public void approveOffer(Long offerId) {
        Offer offer = offerRepository.findById(offerId)
                .orElseThrow(() -> new RuntimeException("Offer not found"));
        offer.setApproved(true);
        offerRepository.save(offer);
    }
}
