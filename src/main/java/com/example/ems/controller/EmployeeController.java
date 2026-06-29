package com.example.ems.controller;

import com.example.ems.dto.EmployeeSummaryDTO;
import com.example.ems.entity.Employee;
import com.example.ems.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    // ── 1. POST /employees — Add Employee ───────────────────────
    @PostMapping
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee) {
        Employee saved = employeeService.addEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // ── 2. GET /employees — View All Employees (summary) ────────
    @GetMapping
    public ResponseEntity<List<EmployeeSummaryDTO>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    // ── 3. GET /employees/{id} — Get Employee by ID ─────────────
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getEmployeeById(id));
    }

    // ── 4. PUT /employees/{id} — Update Employee ─────────────────
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.updateEmployee(id, employee));
    }

    // ── 5. DELETE /employees/{id} — Delete Employee ──────────────
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.deleteEmployee(id));
    }

}
