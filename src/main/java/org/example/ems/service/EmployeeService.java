package org.example.ems.service;

import org.example.ems.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto save(EmployeeDto employeeDto);

    List<EmployeeDto> findAll();

    EmployeeDto findOne(Long id);
}
