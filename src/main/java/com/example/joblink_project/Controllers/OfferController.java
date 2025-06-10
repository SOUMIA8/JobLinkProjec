package com.example.joblink_project.Controllers;

import com.example.joblink_project.Models.Offer;
import com.example.joblink_project.Services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offers")
@CrossOrigin(origins = "*") // Optional: allow frontend access
public class OfferController {

    private final OfferService offerService;

    @Autowired
    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }

    @PostMapping
    public Offer createOffer(@RequestBody Offer offer) {
        return offerService.createOffer(offer);
    }

    @PutMapping("/{id}")
    public Offer updateOffer(@PathVariable Long id, @RequestBody Offer offer) {
        return offerService.updateOffer(id, offer);
    }

    @DeleteMapping("/{id}")
    public void deleteOffer(@PathVariable Long id) {
        offerService.deleteOffer(id);
    }

    @GetMapping
    public List<Offer> getAllOffers() {
        return offerService.getAllOffers();
    }

    @GetMapping("/{id}")
    public Offer getOfferById(@PathVariable Long id) {
        return offerService.getOfferById(id);
    }

    @GetMapping("/recruiter/{recruiterId}")
    public List<Offer> getOffersByRecruiter(@PathVariable Long recruiterId) {
        return offerService.getOffersByRecruiter(recruiterId);
    }

    @PostMapping("/{id}/approve")
    public void approveOffer(@PathVariable Long id) {
        offerService.approveOffer(id);
    }
}
