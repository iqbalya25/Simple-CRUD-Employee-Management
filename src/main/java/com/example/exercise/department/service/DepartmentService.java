package com.example.exercise.department.service;

import com.example.exercise.department.dto.DepartmentDto;
import com.example.exercise.department.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {

    List<Department> getAllDepartment();
    Optional<Department> getDepartmentById(Long id);
    void createDepartment (DepartmentDto department);
    Department updateDepartment (Long id, Department department);
    void deleteDepartment (Long id);

}
