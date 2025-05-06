package com.example.joblink_project.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Recruiters")
@Data
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "user_id")
public class Recruiter extends User {

    @Column(name = "company_name", nullable = false, length = 255)
    private String companyName;

    @Column(name = "company_website", length = 255)
    private String companyWebsite;

    @Column(name = "company_size", length = 100)
    private String companySize;


    @OneToMany(mappedBy = "recruiter", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Offer> offers = new ArrayList<>();

}
