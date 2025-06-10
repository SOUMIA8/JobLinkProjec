package com.example.joblink_project.ServicesImplementation;

import com.example.joblink_project.Models.CVLanguage;
import com.example.joblink_project.Repositories.CVLanguageRepository;
import com.example.joblink_project.Services.CVLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CVLanguageServiceImpl implements CVLanguageService {

    private final CVLanguageRepository cvLanguageRepository;

    @Autowired
    public CVLanguageServiceImpl(CVLanguageRepository cvLanguageRepository) {
        this.cvLanguageRepository = cvLanguageRepository;
    }

    @Override
    public CVLanguage getById(Long id) {
        return cvLanguageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CV Language not found with ID " + id));
    }

    @Override
    public List<CVLanguage> getByCvId(Long cvId) {
        return cvLanguageRepository.findByCvId(cvId);
    }

    @Override
    public CVLanguage create(CVLanguage cvLanguage) {
        return cvLanguageRepository.save(cvLanguage);
    }

    @Override
    public CVLanguage update(Long id, CVLanguage cvLanguageDetails) {
        CVLanguage existing = getById(id);
        existing.setLanguage(cvLanguageDetails.getLanguage());
        existing.setLevel(cvLanguageDetails.getLevel());
        return cvLanguageRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        cvLanguageRepository.deleteById(id);
    }
}
