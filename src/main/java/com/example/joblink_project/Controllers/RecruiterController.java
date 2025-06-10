package com.example.joblink_project.Controllers;

import com.example.joblink_project.Models.Offer;
import com.example.joblink_project.Models.Recruiter;
import com.example.joblink_project.Services.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.joblink_project.Models.Application;
import java.util.List;

@RestController
@RequestMapping("/api/recruiter")



public class RecruiterController {

    private final RecruiterService recruiterService;

    @Autowired
    public RecruiterController(RecruiterService recruiterService) {
        this.recruiterService = recruiterService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recruiter> getRecruiterById(@PathVariable Long id) {
        return ResponseEntity.ok(recruiterService.getRecruiterById(id));
    }

    @GetMapping
    public ResponseEntity<List<Recruiter>> getAllRecruiters() {
        return ResponseEntity.ok(recruiterService.getAllRecruiters());
    }

    @PostMapping
    public ResponseEntity<Recruiter> createRecruiter(@RequestBody Recruiter recruiter) {
        return ResponseEntity.ok(recruiterService.createRecruiter(recruiter));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recruiter> updateRecruiter(@PathVariable Long id, @RequestBody Recruiter recruiterDetails) {
        return ResponseEntity.ok(recruiterService.updateRecruiter(id, recruiterDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecruiter(@PathVariable Long id) {
        recruiterService.deleteRecruiter(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}/stats")
    public ResponseEntity<String> voirStats(@PathVariable Long id) {
        return ResponseEntity.ok(recruiterService.voirStatistiquesOffres(id));
    }

    @GetMapping("/{id}/suggestions")
    public ResponseEntity<String> suggestions(@PathVariable Long id) {
        return ResponseEntity.ok(recruiterService.recevoirSuggestionsAmeliorationOffres(id));
    }

    @GetMapping("/{recruiterId}/offers/{offerId}")
    public ResponseEntity<Offer> getOfferById(@PathVariable Long recruiterId, @PathVariable Long offerId) {
        Offer offer = recruiterService.getOfferById(offerId);
        return ResponseEntity.ok(offer);
    }


    @GetMapping("/{recruiterId}/offers")
    public ResponseEntity<List<Offer>> getOffersByRecruiter(@PathVariable Long recruiterId) {
        List<Offer> offers = recruiterService.getOffersByRecruiter(recruiterId);
        return ResponseEntity.ok(offers);
    }

    @GetMapping("/offers/{offerId}/applications")
    public ResponseEntity<?> getApplicationsByOffer(@PathVariable Long offerId) {
        return ResponseEntity.ok(recruiterService.getApplicationsByOfferId(offerId));
    }

}
