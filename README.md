# 🏢 Employee Management System
> Spring Boot · Spring Data JPA · MySQL · Maven · Java 21

---

## ⚡ Quick Start

### 1. Create the MySQL Database
```sql
CREATE DATABASE employee_db;
```

### 2. Configure your credentials
Open `src/main/resources/application.properties` and set:
```properties
spring.datasource.username=root
spring.datasource.password=your_password_here
```

### 3. Run the app
```bash
mvn spring-boot:run
```
Hibernate auto-creates the `employee` table on first run.

---

## 🔗 API Endpoints

| Method | URL | Description |
|--------|-----|-------------|
| POST | `/employees` | Add new employee |
| GET | `/employees` | View all employees (id, name, department) |
| GET | `/employees/{id}` | Get employee by ID (full details) |
| PUT | `/employees/{id}` | Update employee |
| DELETE | `/employees/{id}` | Delete employee |

---

## 📬 Postman Examples

### ➕ Add Employee
```
POST http://localhost:8080/employees
Content-Type: application/json

{
    "name": "Sneha Dhobale",
    "email": "sneha@gmail.com",
    "department": "IT",
    "salary": 45000
}
```

### 📋 View All
```
GET http://localhost:8080/employees
```
Response:
```json
[
  { "id": 1, "name": "Sneha Dhobale", "department": "IT" },
  { "id": 2, "name": "Rahul Patil",   "department": "HR" }
]
```

### 🔍 Get by ID
```
GET http://localhost:8080/employees/1
```

### ✏️ Update
```
PUT http://localhost:8080/employees/1
Content-Type: application/json

{
    "name": "Sneha Dhobale",
    "email": "sneha.new@gmail.com",
    "department": "Finance",
    "salary": 55000
}
```

### 🗑️ Delete
```
DELETE http://localhost:8080/employees/1
```

---

## ✅ Validations

| Field | Rule | Error Message |
|-------|------|---------------|
| email | Must be valid format | `Invalid Email` |
| salary | Must be ≥ 0 | `Salary cannot be negative` |
| name | Cannot be blank | `Name is required` |
| department | Cannot be blank | `Department is required` |
| email | Must be unique | `Email already exists` |

### Validation Error Response Example
```json
{
  "timestamp": "2025-06-28T10:30:00",
  "status": 400,
  "errors": {
    "email": "Invalid Email",
    "salary": "Salary cannot be negative"
  }
}
```

---

## 🗂️ Project Structure
```
EmployeeManagementSystem
├── pom.xml
└── src/main/
    ├── java/com/example/ems/
    │   ├── EmployeeManagementApplication.java
    │   ├── controller/
    │   │   └── EmployeeController.java
    │   ├── service/
    │   │   └── EmployeeService.java
    │   ├── repository/
    │   │   └── EmployeeRepository.java
    │   ├── entity/
    │   │   └── Employee.java
    │   ├── dto/
    │   │   └── EmployeeSummaryDTO.java
    │   └── exception/
    │       ├── ResourceNotFoundException.java
    │       └── GlobalExceptionHandler.java
    └── resources/
        └── application.properties
```

---

## 🛢️ Database Table (auto-created by Hibernate)
```sql
CREATE TABLE employee (
  id         BIGINT       AUTO_INCREMENT PRIMARY KEY,
  name       VARCHAR(255) NOT NULL,
  email      VARCHAR(255) NOT NULL UNIQUE,
  department VARCHAR(255) NOT NULL,
  salary     DOUBLE       NOT NULL
);
```

---

## 🧰 Tech Stack
- Java 21
- Spring Boot 3.2.5
- Spring Data JPA + Hibernate
- MySQL 8
- Maven
- Lombok
- Bean Validation (jakarta.validation)
