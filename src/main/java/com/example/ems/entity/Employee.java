package com.example.ems.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid Email")
    @Column(nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Department is required")
    @Column(nullable = false)
    private String department;

    @NotNull(message = "Salary is required")
    @Min(value = 0, message = "Salary cannot be negative")
    @Column(nullable = false)
    private Double salary;

}
