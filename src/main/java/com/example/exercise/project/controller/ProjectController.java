package com.example.exercise.project.controller;

import com.example.exercise.employee.entity.Employee;
import com.example.exercise.project.entity.Project;
import com.example.exercise.project.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {
    private ProjectService projectService;

    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        Project createProject = projectService.createProject(project);
                return ResponseEntity.ok().body(project);
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable("id") Long id) {
        Optional<Project> project = projectService.findProjectById(id);
        return project.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") long id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }

}
