package com.mkkcreations.portfolio_server.api.service;

import com.mkkcreations.portfolio_server.api.model.Project;
import com.mkkcreations.portfolio_server.api.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class ProjectService {
    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    LogService logService;

    public Project createProject(Project project) {
        project.setCreatedAt(new Date());
        Project newProject = projectRepository.save(project);
        logService.createLog(
                "Project",
                String.format("Project %s created", project.getTitle()),
                Map.of("title", project.getTitle()));
        return newProject;
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProjectById(String id) {
        return projectRepository.findById(id).orElse(null);
    }

    public Project updateProject(Project project) {
        Project existingProject = projectRepository.findById(project.getId()).orElse(null);
        assert existingProject != null;
        existingProject.setTitle(project.getTitle());
        existingProject.setDescription(project.getDescription());
        existingProject.setStack(project.getStack());
        existingProject.setImages(project.getImages());
        existingProject.setUrl(project.getUrl());
        existingProject.setGithub(project.getGithub());
        existingProject.setCreatedAt(project.getCreatedAt());
        existingProject.setUpdatedAt(new Date());
        logService.createLog(
                "Project",
                String.format("Project %s updated", project.getTitle()),
                Map.of("title", project.getTitle()));
        return projectRepository.save(existingProject);
    }

    public void deleteProject(String id) {
        projectRepository.deleteById(id);
    }
}
