package com.example.joblink_project.Controllers;

import com.example.joblink_project.Models.Application;
import com.example.joblink_project.Services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationService applicationService;
    @Autowired
    public ApplicationController(ApplicationService applicationService){
        this.applicationService = applicationService;
    }
    @PostMapping("/apply")
    public ResponseEntity<Application> applyToOffer(@RequestParam Long offerId, @RequestParam Long candidateId) {
        return ResponseEntity.ok(applicationService.applyToOffer(offerId, candidateId));
    }

    @GetMapping("/candidate/{candidateId}")
    public ResponseEntity<List<Application>> getByCandidate(@PathVariable Long candidateId) {
        return ResponseEntity.ok(applicationService.getApplicationsByCandidate(candidateId));
    }

    @GetMapping("/offer/{offerId}")
    public ResponseEntity<List<Application>> getByOffer(@PathVariable Long offerId) {
        return ResponseEntity.ok(applicationService.getApplicationsByOffer(offerId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Application> getById(@PathVariable Long id) {
        return ResponseEntity.ok(applicationService.getApplicationById(id));
    }

    @PostMapping
    public Application createApplication(@RequestBody Application application) {
        return applicationService.saveApplication(application);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
        applicationService.deleteApplication(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/accept")
    public ResponseEntity<Void> accepter(@PathVariable Long id) {
        applicationService.accepterCandidature(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/reject")
    public ResponseEntity<Void> rejeter(@PathVariable Long id) {
        applicationService.rejeterCandidature(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/contact")
    public ResponseEntity<Void> contacter(@PathVariable Long id, @RequestBody String message) {
        applicationService.contacterCandidatViaPlateforme(id, message);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/question")
    public ResponseEntity<Void> poserQuestion(@PathVariable Long id, @RequestBody String question) {
        applicationService.poserQuestionSurCandidature(id, question);
        return ResponseEntity.ok().build();
    }
}
