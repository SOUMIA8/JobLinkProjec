package com.example.joblink_project.Services;

import com.example.joblink_project.Models.Education;

import java.util.List;

public interface EducationService {
    Education getById(Long id);
    List<Education> getByCvId(Long cvId);
    Education create(Education education);
    Education update(Long id, Education education);
    void delete(Long id);
}
