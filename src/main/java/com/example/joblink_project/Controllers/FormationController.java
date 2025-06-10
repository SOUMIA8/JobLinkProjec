package com.example.joblink_project.Controllers;

import com.example.joblink_project.Models.Formation;
import com.example.joblink_project.Services.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/formations")
public class FormationController {

    private final FormationService formationService;

    @Autowired
    public FormationController(FormationService formationService) {
        this.formationService = formationService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Formation> getById(@PathVariable Long id) {
        return ResponseEntity.ok(formationService.getById(id));
    }

    @GetMapping("/cv/{cvId}")
    public ResponseEntity<List<Formation>> getByCvId(@PathVariable Long cvId) {
        return ResponseEntity.ok(formationService.getByCvId(cvId));
    }

    @PostMapping
    public ResponseEntity<Formation> create(@RequestBody Formation formation) {
        return ResponseEntity.ok(formationService.create(formation));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Formation> update(@PathVariable Long id, @RequestBody Formation formation) {
        return ResponseEntity.ok(formationService.update(id, formation));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        formationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
