package com.example.joblink_project.Repositories;

import com.example.joblink_project.Models.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationRepository extends JpaRepository<Education, Long> {
    List<Education> findByCvId(Long cvId);
}
