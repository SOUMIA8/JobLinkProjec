package com.example.joblink_project.Controllers;

import com.example.joblink_project.Models.Experience;
import com.example.joblink_project.Services.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experiences")
public class ExperienceController {

    private final ExperienceService experienceService;

    @Autowired
    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Experience> getById(@PathVariable Long id) {
        return ResponseEntity.ok(experienceService.getById(id));
    }

    @GetMapping("/cv/{cvId}")
    public ResponseEntity<List<Experience>> getByCvId(@PathVariable Long cvId) {
        return ResponseEntity.ok(experienceService.getByCvId(cvId));
    }

    @PostMapping
    public ResponseEntity<Experience> create(@RequestBody Experience experience) {
        return ResponseEntity.ok(experienceService.create(experience));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Experience> update(@PathVariable Long id, @RequestBody Experience experience) {
        return ResponseEntity.ok(experienceService.update(id, experience));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        experienceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
