package com.example.joblink_project.ServicesImplementation;

import com.example.joblink_project.Models.Education;
import com.example.joblink_project.Repositories.EducationRepository;
import com.example.joblink_project.Services.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationServiceImpl implements EducationService {

    private final EducationRepository educationRepository;

    @Autowired
    public EducationServiceImpl(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    @Override
    public Education getById(Long id) {
        return educationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Education not found with ID " + id));
    }

    @Override
    public List<Education> getByCvId(Long cvId) {
        return educationRepository.findByCvId(cvId);
    }

    @Override
    public Education create(Education education) {
        return educationRepository.save(education);
    }

    @Override
    public Education update(Long id, Education updated) {
        Education existing = getById(id);
        existing.setDegree(updated.getDegree());
        existing.setInstitution(updated.getInstitution());
        existing.setFieldOfStudy(updated.getFieldOfStudy());
        existing.setStartDate(updated.getStartDate());
        existing.setEndDate(updated.getEndDate());
        existing.setDescription(updated.getDescription());
        return educationRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        educationRepository.deleteById(id);
    }
}
