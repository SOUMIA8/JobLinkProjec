package com.example.joblink_project.Controllers;

import com.example.joblink_project.Models.CVLanguage;
import com.example.joblink_project.Services.CVLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cv-languages")
public class CVLanguageController {

    private final CVLanguageService cvLanguageService;

    @Autowired
    public CVLanguageController(CVLanguageService cvLanguageService) {
        this.cvLanguageService = cvLanguageService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CVLanguage> getById(@PathVariable Long id) {
        return ResponseEntity.ok(cvLanguageService.getById(id));
    }

    @GetMapping("/cv/{cvId}")
    public ResponseEntity<List<CVLanguage>> getByCvId(@PathVariable Long cvId) {
        return ResponseEntity.ok(cvLanguageService.getByCvId(cvId));
    }

    @PostMapping
    public ResponseEntity<CVLanguage> create(@RequestBody CVLanguage cvLanguage) {
        return ResponseEntity.ok(cvLanguageService.create(cvLanguage));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CVLanguage> update(@PathVariable Long id, @RequestBody CVLanguage cvLanguage) {
        return ResponseEntity.ok(cvLanguageService.update(id, cvLanguage));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        cvLanguageService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
