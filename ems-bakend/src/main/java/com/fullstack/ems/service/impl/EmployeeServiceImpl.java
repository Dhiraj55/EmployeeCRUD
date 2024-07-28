package com.fullstack.ems.service.impl;

import org.springframework.stereotype.Service;

import com.fullstack.ems.dto.EmployeeDto;
import com.fullstack.ems.entity.Employee;
import com.fullstack.ems.mapper.EmployeeMapper;
import com.fullstack.ems.repository.EmployeeRepository;
import com.fullstack.ems.service.IEmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements IEmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee saveEmployee= employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(saveEmployee);
    }
}
