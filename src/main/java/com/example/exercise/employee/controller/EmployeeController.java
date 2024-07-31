package com.example.exercise.employee.controller;

import com.example.exercise.department.entity.Department;
import com.example.exercise.employee.dto.EmployeeDto;
import com.example.exercise.employee.entity.Employee;
import com.example.exercise.employee.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }

    @PostMapping("/register")
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeDto employee) {
        employeeService.createdEmployee(employee);
        return ResponseEntity.ok("createdEmployee");
    }


    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") long id) {
        Optional<Employee> employee = employeeService.findById(id);
        return employee.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable("id") long id, @RequestBody EmployeeDto employee) {
        employee.setId(id);
        employeeService.updateEmployee(employee);
        return ResponseEntity.ok("updatedEmployee");
    }

}
