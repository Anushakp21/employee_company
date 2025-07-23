package com.example.employee_company.dto;

import com.example.employee_company.entity.Employee;

public class EmployeeResponse {
    private Employee employee;
    private CompanyDto companyDto;

    public EmployeeResponse(Employee employee,CompanyDto companyDto){
        this.employee=employee;
        this.companyDto=companyDto;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public CompanyDto getCompanyDto() {
        return companyDto;
    }

    public void setCompanyDto(CompanyDto companyDto) {
        this.companyDto = companyDto;
    }
}
