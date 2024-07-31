package com.example.exercise.employee.entity;


import com.example.exercise.department.entity.Department;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;


@Data
@Entity
@Table (name = "employee")
public class Employee  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_id_gen")
    @SequenceGenerator(name = "employee_id_gen", sequenceName = "employee_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "First name can't be empty")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank(message = "Last name can't be empty")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotBlank(message = "Email cannot be empty")
    @Column(name = "email", nullable = false)
    private String email;

    @NotBlank(message = "Phone number cannot be empty")
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "hire_date")
    private Date hireDate;

    @Column(name = "job_title")
    private String jobTitle;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;


}

