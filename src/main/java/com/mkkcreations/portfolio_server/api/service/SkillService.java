package com.mkkcreations.portfolio_server.api.service;

import com.mkkcreations.portfolio_server.api.model.Log;
import com.mkkcreations.portfolio_server.api.model.Skill;
import com.mkkcreations.portfolio_server.api.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SkillService {
    @Autowired
    SkillRepository skillRepository;
    @Autowired
    LogService logService;


    public Skill createSkill(Skill skill) {
        logService.createLog(
                "Skill",
                String.format("Skill %s created", skill.getName()),
                Map.of("name", skill.getName()));
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
        logService.createLog(
                "Skill",
                String.format("Skill %s updated", skill.getName()),
                Map.of("name", skill.getName()));
        return skillRepository.save(existingSkill);
    }

    public void deleteSkill(String id) {
        skillRepository.deleteById(id);
    }
}
