package com.example.joblink_project.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "CV_Languages")
@Data
public class CVLanguage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String language;

    @Column(nullable = false, length = 100)
    private String level;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_id", nullable = false)
    private CV cv;

}
