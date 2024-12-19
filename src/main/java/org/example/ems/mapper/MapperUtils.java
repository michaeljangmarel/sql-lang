package org.example.ems.mapper;

import org.example.ems.dto.EmployeeDto;
import org.example.ems.model.Employee;
import org.springframework.beans.BeanUtils;

public class MapperUtils {

    public  static EmployeeDto EmpToDto(Employee emp) {
       return  new EmployeeDto(emp.getId() , emp.getFirstName(), emp.getLastName(), emp.getEmail());
    }
    public  static Employee DtoToEmp(EmployeeDto dto) {
        return new Employee(dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getEmail());
    }
}
