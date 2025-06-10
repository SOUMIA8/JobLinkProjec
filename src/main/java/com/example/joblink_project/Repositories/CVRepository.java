package com.example.joblink_project.Repositories;

import com.example.joblink_project.Models.CV;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CVRepository extends JpaRepository<CV, Long> {
    List<CV> findByCandidateId(Long candidateId);
}
