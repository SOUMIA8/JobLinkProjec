package com.example.joblink_project.Services;

import com.example.joblink_project.Models.Formation;

import java.util.List;

public interface FormationService {
    Formation getById(Long id);
    List<Formation> getByCvId(Long cvId);
    Formation create(Formation formation);
    Formation update(Long id, Formation formation);
    void delete(Long id);
}
