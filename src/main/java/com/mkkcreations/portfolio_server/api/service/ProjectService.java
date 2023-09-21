package com.mkkcreations.portfolio_server.api.service;

import com.mkkcreations.portfolio_server.api.model.Project;
import com.mkkcreations.portfolio_server.api.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(final ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
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
        existingProject.setCreatedAt(project.getCreatedAt());
        existingProject.setUpdatedAt(new Date());
        return projectRepository.save(existingProject);
    }

    public void deleteProject(String id) {
        projectRepository.deleteById(id);
    }
}
