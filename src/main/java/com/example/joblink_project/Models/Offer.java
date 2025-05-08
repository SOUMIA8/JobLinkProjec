package com.example.joblink_project.Models;
import com.example.joblink_project.Enum.ContractType;
import com.example.joblink_project.Enum.ExperienceLevel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Offers")
@Data
@NoArgsConstructor
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String title;

    @Lob
    @Column(nullable = false)
    private String description;

    @Column(length = 255)
    private String location;

    private Double salary;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "ENUM('CDI', 'CDD', 'STAGE', 'FREELANCE')")
    private ContractType contractType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "ENUM('JUNIOR', 'SENIOR', 'EXPERT')")
    private ExperienceLevel experienceLevel;

    @Column(nullable = false)
    private LocalDate publicationDate;

    @Column(nullable = false)
    private LocalDate expirationDate;

    @Column(columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean isApproved = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recruiter_id")
    private Recruiter recruiter;

    @OneToMany(mappedBy = "offer")
    private List<Application> applications;

    @OneToMany(mappedBy = "offer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();
}

