package com.example.exercise.employee.service.impl;

import com.example.exercise.department.entity.Department;
import com.example.exercise.department.repository.DepartmentRepository;
import com.example.exercise.employee.dto.EmployeeDto;
import com.example.exercise.employee.entity.Employee;
import com.example.exercise.employee.repository.EmployeeRepository;
import com.example.exercise.employee.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private DepartmentRepository departmentRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void createdEmployee(EmployeeDto employee) {

        Employee newEmployee = new Employee();
        newEmployee.setFirstName(employee.getFirstName());
        newEmployee.setLastName(employee.getLastName());
        newEmployee.setEmail(employee.getEmail());
        newEmployee.setPhoneNumber(employee.getPhoneNumber());
        newEmployee.setJobTitle(employee.getJobTitle());

        Optional<Department> department = departmentRepository.findById(employee.getDepartmentId());
        department.ifPresent(newEmployee::setDepartment);

        employeeRepository.save(newEmployee);
    }


    @Override
    public Employee updateEmployee(EmployeeDto employeeDto) {
    Optional<Employee> existingEmployeeOptional = employeeRepository.findById(employeeDto.getId());
        if (existingEmployeeOptional.isPresent()) {
            Employee existingEmployee = existingEmployeeOptional.get();
            existingEmployee.setFirstName(employeeDto.getFirstName());
            existingEmployee.setLastName(employeeDto.getLastName());
            existingEmployee.setEmail(employeeDto.getEmail());
            existingEmployee.setPhoneNumber(employeeDto.getPhoneNumber());
            existingEmployee.setJobTitle(employeeDto.getJobTitle());

            Optional<Department> department = departmentRepository.findById(employeeDto.getDepartmentId());
            department.ifPresent(existingEmployee::setDepartment);

            return employeeRepository.save(existingEmployee);
        } else {
            throw new RuntimeException("employee not found with id: " + employeeDto.getId());
        }
    }

    @Override
    public void deleteEmployee(long id) {

    }

    @Override
    public Optional<Employee> findById(Long id) {
        return Optional.empty();
    }
}
