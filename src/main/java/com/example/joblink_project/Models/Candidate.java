package com.example.joblink_project.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Candidates")
@Data
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "user_id")
public class Candidate extends User {

    @Column(name = "profession", length = 100)
    private String profession;

    @Column(name = "skills", columnDefinition = "TEXT")
    private String skills;

    @Column(name = "experience", columnDefinition = "TEXT")
    private String experience;

    @OneToMany(mappedBy = "candidate")
    private List<Application> applications;

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

}
