package com.example.joblink_project.Services;

import com.example.joblink_project.Models.Experience;

import java.util.List;

public interface ExperienceService {
    Experience getById(Long id);
    List<Experience> getByCvId(Long cvId);
    Experience create(Experience experience);
    Experience update(Long id, Experience experience);
    void delete(Long id);
}
