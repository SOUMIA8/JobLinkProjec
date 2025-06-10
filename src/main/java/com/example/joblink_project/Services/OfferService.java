package com.example.joblink_project.Services;

import com.example.joblink_project.Models.Offer;

import java.util.List;

public interface OfferService {
    Offer createOffer(Offer offer);
    Offer updateOffer(Long id, Offer offer);
    void deleteOffer(Long id);
    Offer getOfferById(Long id);
    List<Offer> getAllOffers();
    List<Offer> getOffersByRecruiter(Long recruiterId);
    void approveOffer(Long offerId);

}
