package com.example.ems.repository;

import com.example.ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Check if email already exists (used for duplicate validation)
    boolean existsByEmail(String email);

    // Find employee by email
    Optional<Employee> findByEmail(String email);

}
