package com.example.ems.service;

import com.example.ems.dto.EmployeeSummaryDTO;
import com.example.ems.entity.Employee;
import com.example.ems.exception.ResourceNotFoundException;
import com.example.ems.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    // ── 1. Add Employee ──────────────────────────────────────────
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // ── 2. Get All Employees (summary: id, name, department) ─────
    public List<EmployeeSummaryDTO> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(emp -> EmployeeSummaryDTO.builder()
                        .id(emp.getId())
                        .name(emp.getName())
                        .department(emp.getDepartment())
                        .build())
                .collect(Collectors.toList());
    }

    // ── 3. Get Employee by ID (full details) ─────────────────────
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Employee not found with id: " + id));
    }

    // ── 4. Update Employee ────────────────────────────────────────
    public Employee updateEmployee(Long id, Employee updatedData) {
        Employee existing = getEmployeeById(id);

        existing.setName(updatedData.getName());
        existing.setEmail(updatedData.getEmail());
        existing.setDepartment(updatedData.getDepartment());
        existing.setSalary(updatedData.getSalary());

        return employeeRepository.save(existing);
    }

    // ── 5. Delete Employee ────────────────────────────────────────
    public String deleteEmployee(Long id) {
        Employee existing = getEmployeeById(id);
        employeeRepository.delete(existing);
        return "Employee with id " + id + " deleted successfully";
    }

}
