package com.example.exercise.department.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "department_id_gen")
    @SequenceGenerator(name = "department_id_gen", sequenceName = "department_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private long id;

    @NotBlank(message = "Name can't be empty")
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "location")
    private String location;
}
