package com.example.joblink_project.ServicesImplementation;

import com.example.joblink_project.Models.Skill;
import com.example.joblink_project.Repositories.SkillRepository;
import com.example.joblink_project.Services.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;

    @Autowired
    public SkillServiceImpl(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @Override
    public Skill getById(Long id) {
        return skillRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Skill not found with ID: " + id));
    }

    @Override
    public List<Skill> getByCvId(Long cvId) {
        return skillRepository.findByCvId(cvId);
    }

    @Override
    public Skill create(Skill skill) {
        return skillRepository.save(skill);
    }

    @Override
    public Skill update(Long id, Skill updatedSkill) {
        Skill existing = getById(id);
        existing.setName(updatedSkill.getName());
        return skillRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        skillRepository.deleteById(id);
    }
}
