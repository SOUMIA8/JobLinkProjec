package com.example.joblink_project.Services;

import com.example.joblink_project.Models.Skill;

import java.util.List;

public interface SkillService {
    Skill getById(Long id);
    List<Skill> getByCvId(Long cvId);
    Skill create(Skill skill);
    Skill update(Long id, Skill updatedSkill);
    void delete(Long id);
}
