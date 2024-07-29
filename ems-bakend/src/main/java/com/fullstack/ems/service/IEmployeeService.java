package com.fullstack.ems.service;

import java.util.List;

import com.fullstack.ems.dto.EmployeeDto;

public interface IEmployeeService {
    EmployeeDto  createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployee(Long employeeID);

    List<EmployeeDto> getAllEmployee();
}
