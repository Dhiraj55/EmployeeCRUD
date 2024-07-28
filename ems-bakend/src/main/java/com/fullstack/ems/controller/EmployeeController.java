package com.fullstack.ems.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.ems.dto.EmployeeDto;
import com.fullstack.ems.service.IEmployeeService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private IEmployeeService employeeService;

    //Build Add Employee REST API
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDto> createEmployee( @RequestBody EmployeeDto employeeDto){
        EmployeeDto saveEmployeeDto = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(saveEmployeeDto , HttpStatus.CREATED);
    }
}
