package com.example.joblink_project.ServicesImplementation;

import com.example.joblink_project.Models.Experience;
import com.example.joblink_project.Repositories.ExperienceRepository;
import com.example.joblink_project.Services.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceServiceImpl implements ExperienceService {

    private final ExperienceRepository experienceRepository;

    @Autowired
    public ExperienceServiceImpl(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    @Override
    public Experience getById(Long id) {
        return experienceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Experience not found with ID: " + id));
    }

    @Override
    public List<Experience> getByCvId(Long cvId) {
        return experienceRepository.findByCvId(cvId);
    }

    @Override
    public Experience create(Experience experience) {
        return experienceRepository.save(experience);
    }

    @Override
    public Experience update(Long id, Experience updatedExperience) {
        Experience existing = getById(id);
        existing.setPosition(updatedExperience.getPosition());
        existing.setStartDate(updatedExperience.getStartDate());
        existing.setEndDate(updatedExperience.getEndDate());
        existing.setCompany(updatedExperience.getCompany());
        existing.setDescription(updatedExperience.getDescription());
        return experienceRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        experienceRepository.deleteById(id);
    }
}
