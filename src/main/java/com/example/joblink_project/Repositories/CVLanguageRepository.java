package com.example.joblink_project.Repositories;

import com.example.joblink_project.Models.CVLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CVLanguageRepository extends JpaRepository<CVLanguage, Long> {
    List<CVLanguage> findByCvId(Long cvId);
}
