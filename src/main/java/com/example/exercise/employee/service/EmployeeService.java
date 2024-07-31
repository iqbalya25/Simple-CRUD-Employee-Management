package com.example.exercise.employee.service;

import com.example.exercise.employee.dto.EmployeeDto;
import com.example.exercise.employee.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findAll();
    Optional<Employee> findById(long id);
    void createdEmployee(EmployeeDto employee);
    Employee updateEmployee(EmployeeDto employeeDto);
    void deleteEmployee(long id);

    Optional<Employee> findById(Long id);
}
