package com.example.employee_company.service;

import com.example.employee_company.dto.CompanyDto;
import com.example.employee_company.dto.EmployeeResponse;
import com.example.employee_company.entity.Employee;
import com.example.employee_company.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Long employeeId, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(employeeId).orElseThrow();
        existingEmployee.setEmployeeName(employee.getEmployeeName());
        existingEmployee.setRole(employee.getRole());
        existingEmployee.setCompanyId(employee.getCompanyId());
        return employeeRepository.save(existingEmployee);
    }

    @Override
    public EmployeeResponse getEmployeeWithCompanyDetails(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow();

        CompanyDto companyDto = restTemplate.getForObject(
                "http://localhost:8081/getById/" + employee.getCompanyId(),
                CompanyDto.class
        );

        return new EmployeeResponse(employee, companyDto);
    }
}
