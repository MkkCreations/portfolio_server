package com.mkkcreations.portfolio_server.api.service;

import com.mkkcreations.portfolio_server.api.model.Skill;
import com.mkkcreations.portfolio_server.api.repository.SkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {
    private final SkillRepository skillRepository;

    public SkillService(final SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public Skill createSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    public Skill getSkillById(String id) {
        return skillRepository.findById(id).orElse(null);
    }

    public Skill updateSkill(Skill skill) {
        Skill existingSkill = skillRepository.findById(skill.getId()).orElse(null);
        assert existingSkill != null;
        existingSkill.setName(skill.getName());
        existingSkill.setDescription(skill.getDescription());
        existingSkill.setIcon(skill.getIcon());
        return skillRepository.save(existingSkill);
    }

    public void deleteSkill(String id) {
        skillRepository.deleteById(id);
    }
}
