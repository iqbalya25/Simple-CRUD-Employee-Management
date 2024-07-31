package com.example.exercise.project.service;

import com.example.exercise.project.entity.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    List<Project> findAllProjects();
    Optional<Project> findProjectById(long id);
    Project createProject(Project project);
    Project updateProject(Project project);
    void deleteProject(long id);

    List<Project> getAllProjects();
}
