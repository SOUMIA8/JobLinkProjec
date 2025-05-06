package com.example.joblink_project.Models;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Formations")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_id", nullable = false)
    private CV cv;


    /*public void addToCV(CV cv) {
        this.setCv(cv);
        cv.getFormations().add(this);
    }*/
}