package com.example.joblink_project.ServicesImplementation;

import com.example.joblink_project.Models.Formation;
import com.example.joblink_project.Repositories.FormationRepository;
import com.example.joblink_project.Services.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormationServiceImpl implements FormationService {

    private final FormationRepository formationRepository;

    @Autowired
    public FormationServiceImpl(FormationRepository formationRepository) {
        this.formationRepository = formationRepository;
    }

    @Override
    public Formation getById(Long id) {
        return formationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Formation not found with ID: " + id));
    }

    @Override
    public List<Formation> getByCvId(Long cvId) {
        return formationRepository.findByCvId(cvId);
    }

    @Override
    public Formation create(Formation formation) {
        return formationRepository.save(formation);
    }

    @Override
    public Formation update(Long id, Formation updatedFormation) {
        Formation existing = getById(id);
        existing.setName(updatedFormation.getName());
        return formationRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        formationRepository.deleteById(id);
    }
}
