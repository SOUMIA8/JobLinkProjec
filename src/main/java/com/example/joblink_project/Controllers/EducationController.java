package com.example.joblink_project.Controllers;

import com.example.joblink_project.Models.Education;
import com.example.joblink_project.Services.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/educations")
public class EducationController {

    private final EducationService educationService;

    @Autowired
    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Education> getById(@PathVariable Long id) {
        return ResponseEntity.ok(educationService.getById(id));
    }

    @GetMapping("/cv/{cvId}")
    public ResponseEntity<List<Education>> getByCvId(@PathVariable Long cvId) {
        return ResponseEntity.ok(educationService.getByCvId(cvId));
    }

    @PostMapping
    public ResponseEntity<Education> create(@RequestBody Education education) {
        return ResponseEntity.ok(educationService.create(education));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Education> update(@PathVariable Long id, @RequestBody Education education) {
        return ResponseEntity.ok(educationService.update(id, education));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        educationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
