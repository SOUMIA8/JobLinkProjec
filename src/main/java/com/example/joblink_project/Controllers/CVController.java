package com.example.joblink_project.Controllers;

import com.example.joblink_project.Models.CV;
import com.example.joblink_project.Services.CVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cvs")
public class CVController {

    private final CVService cvService;

    @Autowired
    public CVController(CVService cvService) {
        this.cvService = cvService;
    }

    @GetMapping
    public ResponseEntity<List<CV>> getAllCVs() {
        return ResponseEntity.ok(cvService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CV> getById(@PathVariable Long id) {
        return ResponseEntity.ok(cvService.getById(id));
    }

    @GetMapping("/candidate/{candidateId}")
    public ResponseEntity<List<CV>> getByCandidateId(@PathVariable Long candidateId) {
        return ResponseEntity.ok(cvService.getByCandidateId(candidateId));
    }

    @PostMapping
    public ResponseEntity<CV> create(@RequestBody CV cv) {
        return ResponseEntity.ok(cvService.create(cv));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CV> update(@PathVariable Long id, @RequestBody CV cv) {
        return ResponseEntity.ok(cvService.update(id, cv));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cvService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
