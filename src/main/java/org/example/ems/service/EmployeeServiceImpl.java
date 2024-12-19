package org.example.ems.service;

import org.example.ems.dto.EmployeeDto;
import org.example.ems.exception.ResourceNotFoundException;
import org.example.ems.mapper.MapperUtils;
import org.example.ems.model.Employee;
import org.example.ems.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
 public class EmployeeServiceImpl  implements EmployeeService{
    @Autowired
    private  EmployeeRepo employeeRepo;

    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
        Employee employee = MapperUtils.DtoToEmp(employeeDto);
        Employee emp =employeeRepo.save(employee);
        return MapperUtils.EmpToDto(emp);
    }

    @Override
    public List<EmployeeDto> findAll() {
        List<EmployeeDto> emp =  employeeRepo.findAll().stream().map(MapperUtils::EmpToDto).collect(Collectors.toUnmodifiableList());
        return emp;
    }

    @Override
    public EmployeeDto findOne(Long id) {
       EmployeeDto  employeeDto = employeeRepo.findById(id).map(MapperUtils::EmpToDto).orElseThrow(() -> new ResourceNotFoundException("resource not found"));
       return employeeDto;
    }


}
