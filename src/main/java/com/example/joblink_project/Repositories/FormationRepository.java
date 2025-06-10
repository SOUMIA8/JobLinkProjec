package com.example.joblink_project.Repositories;

import com.example.joblink_project.Models.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormationRepository extends JpaRepository<Formation, Long> {
    List<Formation> findByCvId(Long cvId);
}
