package com.example.exercise.department.controller;

import com.example.exercise.department.dto.DepartmentDto;
import com.example.exercise.department.entity.Department;
import com.example.exercise.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> createDepartment(@RequestBody DepartmentDto department) {
    departmentService.createDepartment(department);
    return ResponseEntity.ok("Department created");
    }


    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartment();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") long id) {
        Optional<Department> department = departmentService.getDepartmentById(id);
        return department.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable long id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }
}
