package com.example.exercise.department.service.impl;

import com.example.exercise.department.dto.DepartmentDto;
import com.example.exercise.department.entity.Department;
import com.example.exercise.department.repository.DepartmentRepository;
import com.example.exercise.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    @Override
    public void createDepartment(DepartmentDto department) {
        Department newDepartment = new Department();
        newDepartment.setName(department.getName());
        newDepartment.setLocation(department.getLocation());
        departmentRepository.save(newDepartment);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        return null;
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

}
