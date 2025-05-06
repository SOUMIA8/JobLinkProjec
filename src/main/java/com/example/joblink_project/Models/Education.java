package com.example.joblink_project.Models;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "Educations")
@Data

public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String degree;

    @Column(nullable = false, length = 255)
    private String institution;

    @Column(name = "field_of_study", length = 255)
    private String fieldOfStudy;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Lob
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_id", nullable = false)
    private CV cv;

    // Méthode helper pour la relation bidirectionnelle
    /*public void associateWithCV(CV cv) {
        this.cv = cv;
        cv.getEducations().add(this);
    }*/
}