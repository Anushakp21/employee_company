package com.example.employee_company.controller;

import com.example.employee_company.dto.CompanyDto;
import com.example.employee_company.dto.EmployeeResponse;
import com.example.employee_company.entity.Employee;
import com.example.employee_company.repository.EmployeeRepository;
import com.example.employee_company.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/getEmployee")
    public List<Employee> getEmployees(){
        return employeeService.getAllEmployees();
    }

    @PutMapping("/updateEmployee/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        return employeeService.updateEmployee(id, employee);
    }

    @GetMapping("/{employeeId}")
    public EmployeeResponse getEmployeeWithCompanyDetails(@PathVariable Long employeeId){
        return employeeService.getEmployeeWithCompanyDetails(employeeId);
    }
}
