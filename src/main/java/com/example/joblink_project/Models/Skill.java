package com.example.joblink_project.Models;

import com.example.joblink_project.Models.CV;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Skills")
@Data

public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_id", nullable = false)
    private CV cv;

    // Méthode helper pour la relation bidirectionnelle

    /*public void associateWithCV(CV cv) {
        this.cv = cv;
        cv.getSkills().add(this);
    }*/
}