package com.example.joblink_project.Models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "Experiences")
@Data
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String position;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(nullable = false, length = 255)
    private String company;

    @Lob // Pour les grands textes (équivalent à TEXT en SQL)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_id", nullable = false)
    private CV cv;




    // Méthode utilitaire pour lier l'expérience à un CV
    /*public void associateWithCV(CV cv) {
        this.cv = cv;
        cv.getExperiences().add(this);
    }*/
}