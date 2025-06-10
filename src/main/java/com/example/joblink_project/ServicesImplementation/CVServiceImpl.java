package com.example.joblink_project.ServicesImplementation;

import com.example.joblink_project.Models.CV;
import com.example.joblink_project.Repositories.CVRepository;
import com.example.joblink_project.Services.CVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CVServiceImpl implements CVService {

    private final CVRepository cvRepository;

    @Autowired
    public CVServiceImpl(CVRepository cvRepository) {
        this.cvRepository = cvRepository;
    }

    @Override
    public CV getById(Long id) {
        return cvRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CV not found with ID: " + id));
    }

    @Override
    public List<CV> getAll() {
        return cvRepository.findAll();
    }

    @Override
    public List<CV> getByCandidateId(Long candidateId) {
        return cvRepository.findByCandidateId(candidateId);
    }

    @Override
    public CV create(CV cv) {
        return cvRepository.save(cv);
    }

    @Override
    public CV update(Long id, CV updatedCV) {
        CV existing = getById(id);
        existing.setTitle(updatedCV.getTitle());
        existing.setFullName(updatedCV.getFullName());
        existing.setAddress(updatedCV.getAddress());
        existing.setPhone(updatedCV.getPhone());
        existing.setEmail(updatedCV.getEmail());
        existing.setPortfolioLink(updatedCV.getPortfolioLink());
        existing.setLinkedinLink(updatedCV.getLinkedinLink());
        existing.setAbout(updatedCV.getAbout());
        return cvRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        cvRepository.deleteById(id);
    }
}
