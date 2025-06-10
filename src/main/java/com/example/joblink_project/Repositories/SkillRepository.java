package com.example.joblink_project.Repositories;

import com.example.joblink_project.Models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
    List<Skill> findByCvId(Long cvId);
}
