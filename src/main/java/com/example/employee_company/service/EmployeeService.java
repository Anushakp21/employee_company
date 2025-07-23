package com.example.employee_company.service;

import com.example.employee_company.dto.EmployeeResponse;
import com.example.employee_company.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee updateEmployee(Long employeeId, Employee employee);
    EmployeeResponse getEmployeeWithCompanyDetails(Long employeeId);
}
