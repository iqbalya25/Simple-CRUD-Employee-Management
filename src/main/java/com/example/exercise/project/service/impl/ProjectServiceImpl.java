package com.example.exercise.project.service.impl;

import com.example.exercise.project.entity.Project;
import com.example.exercise.project.repository.ProjectRepository;
import com.example.exercise.project.service.ProjectService;

import java.util.List;
import java.util.Optional;

public class ProjectServiceImpl implements ProjectService {
    private ProjectRepository projectRepository;

    @Override
    public List<Project> findAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Optional<Project> findProjectById(long id) {
        return Optional.empty();
    }

    @Override
    public Project createProject(Project project) {
        return null;
    }

    @Override
    public Project updateProject(Project project) {
        return null;
    }

    @Override
    public void deleteProject(long id) {

    }

    @Override
    public List<Project> getAllProjects() {
        return List.of();
    }
}
