package com.mkkcreations.portfolio_server.api.rest;

import com.mkkcreations.portfolio_server.api.model.Skill;
import com.mkkcreations.portfolio_server.api.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillREST {
    private final SkillService skillService;

    @Autowired
    public SkillREST(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping
    public List<Skill> getAllSkills() {
        return skillService.getAllSkills();
    }

    @GetMapping("/{id}")
    public Skill getSkillById(@PathVariable String id) {
        return skillService.getSkillById(id);
    }

    @PostMapping
    public Skill addSkill(@RequestBody Skill skill) {
        return skillService.createSkill(skill);
    }

    @PutMapping("/{id}")
    public Skill updateSkill(@PathVariable String id, @RequestBody Skill skill) {
        return skillService.updateSkill(skill);
    }

    @DeleteMapping("/{id}")
    public void deleteSkill(@PathVariable String id) {
        skillService.deleteSkill(id);
    }
}
