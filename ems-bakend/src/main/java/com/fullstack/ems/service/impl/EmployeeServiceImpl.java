package com.fullstack.ems.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fullstack.ems.dto.EmployeeDto;
import com.fullstack.ems.entity.Employee;
import com.fullstack.ems.exception.ResourceNotFoundException;
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

    @Override
    public EmployeeDto getEmployee(Long employeeID) {
        Employee getEmployee = employeeRepository.findById(employeeID)
                .orElseThrow(() -> new ResourceNotFoundException("Employee Is Not Exist With Given Id " + employeeID));
        return EmployeeMapper.mapToEmployeeDto(getEmployee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().map((employee -> EmployeeMapper.mapToEmployeeDto(employee))).collect(Collectors.toList());
    }
}
